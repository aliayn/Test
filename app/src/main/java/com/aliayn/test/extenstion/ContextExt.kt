package com.aliayn.test.extenstion

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

fun isOnMainThread(): Boolean = Looper.myLooper() == Looper.getMainLooper()

private fun doToast(context: Context?, message: String, length: Int) {
    if (context == null) return
    if (context is Activity) {
        if (!context.isFinishing && !context.isDestroyed) Toast.makeText(context, message, length).show()
    } else {
        Toast.makeText(context, message, length).show()
    }
}

fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    try {
        if (isOnMainThread()) {
            doToast(context = this, message = msg, length = length)
        } else {
            Handler(Looper.getMainLooper()).post { doToast(context = this, message = msg, length = length) }
        }
    } catch (e: Exception) {
    }
}