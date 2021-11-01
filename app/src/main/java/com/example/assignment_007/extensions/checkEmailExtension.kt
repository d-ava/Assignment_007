package com.example.assignment_007.extensions

fun String.checkEmail() = android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()