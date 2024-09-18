package com.sanusi.shakeinputsdk

import android.annotation.SuppressLint
import android.content.Context

class MySDK private constructor(private val context: Context) {
    private var shakeDetector: ShakeDetector? = null
    private var isShakeEnabled = false

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: MySDK? = null

        @JvmStatic
        fun initialize(context: Context): MySDK {
            if (instance == null) {
                instance = MySDK(context)
            }
            return instance!!
        }
    }

    fun enableShakeGesture(onAppShake: (Boolean) -> Unit) {
        // Implement your logic for enabling gestures
        shakeDetector = ShakeDetector(context) {
            onAppShake(true)
        }

        // Start the ShakeDetector
        shakeDetector?.start()
        isShakeEnabled = true
    }

    fun disableShakeGesture() {
        shakeDetector?.stop()
    }

    private fun showInputModal(onTextSubmitted: (Boolean) -> Unit) {
        onTextSubmitted(true)
    }
}

