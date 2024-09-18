package com.sanusi.shakerapi

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ShakeInputModal(
    showModal: Boolean,
    onDismiss: () -> Unit,
    onSubmit: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    if (showModal) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Enter Text") },
            text = {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Your message") }
                )
            },
            confirmButton = {
                Button(onClick = {
                    onSubmit(text)
                    onDismiss()
                }) {
                    Text("Submit")
                }
            },
            dismissButton = {
                Button(onClick = onDismiss) {
                    Text("Cancel")
                }
            }
        )
    }
}

