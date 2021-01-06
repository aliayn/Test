package com.aliayn.test

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Kotpref.init(context = this)
    }
}