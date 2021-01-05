package com.aliayn.test.helper

import com.chibatching.kotpref.KotprefModel
import com.chibatching.kotpref.blockingBulk

object Config : KotprefModel() {

    override val kotprefName: String = "Prefs"

    fun reset(): Unit = blockingBulk { clear() }
}