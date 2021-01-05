package com.aliayn.test

import android.app.Application
import com.chibatching.kotpref.Kotpref

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Kotpref.init(context = this)
    }
}