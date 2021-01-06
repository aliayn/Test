package com.aliayn.test.extenstion

import java.util.regex.Pattern


fun String.isPasswordValid(): Boolean {
    val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$"
    val pattern = Pattern.compile(passwordPattern)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}