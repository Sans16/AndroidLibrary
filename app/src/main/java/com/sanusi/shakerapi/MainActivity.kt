package com.sanusi.shakerapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sanusi.shakerapi.ui.theme.ShakerAPITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var showModal by remember { mutableStateOf(false) }

             //Initialize the SDK
            val sdk = MySDK.initialize(this)

          //  val sdk = MySDK.initialize(this)

            sdk.enableShakeGesture { status ->
              //  Log.i("TAG",text)
               // Toast.makeText(LocalContext.current, "response", Toast.LENGTH_SHORT).show()
                showModal = status
                // Offload the sending task to a background thread
                CoroutineScope(Dispatchers.IO).launch {
                    Log.i("TAG","SDK")
                }
            }

            ShakeInputModal(
                showModal = showModal,
                onDismiss = { showModal = false },
                onSubmit = { text ->
                    Log.d("MainActivity", "User submitted: $text")
                    sdk.disableShakeGesture()  // Optionally disable shake after text submission
                    showModal = false  // Hide the modal
                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        MySDK.instance?.disableShakeGesture()
    }

    // Background network task
    private suspend fun sendTextToServer(text: String) {
        // Perform your network call here on a background thread
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShakerAPITheme {
        Greeting("Android")
    }
}





