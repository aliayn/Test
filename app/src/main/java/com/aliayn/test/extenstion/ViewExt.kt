package com.aliayn.test.extenstion

import android.view.View

fun View.beGone() {
    visibility = View.GONE
}

fun View.beDisable() {
    isEnabled = false
}

fun View.beGoneIf(beGone: Boolean): Unit = beVisibleIf(!beGone)

fun View.beDisableIf(beDisable: Boolean): Unit = beEnableIf(!beDisable)

fun View.beInvisible() {
    visibility = View.INVISIBLE
}

fun View.beInvisibleIf(beInvisible: Boolean): Unit = if (beInvisible) beInvisible() else beVisible()

fun View.beVisible() {
    visibility = View.VISIBLE
}

fun View.beEnable() {
    isEnabled = true
}

fun View.beVisibleIf(beVisible: Boolean): Unit = if (beVisible) beVisible() else beGone()

fun View.beEnableIf(beEnable: Boolean): Unit = if (beEnable) beEnable() else beDisable()