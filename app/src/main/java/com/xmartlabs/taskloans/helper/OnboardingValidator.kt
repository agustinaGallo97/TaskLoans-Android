package com.xmartlabs.taskloans.helper

private const val MIN_PASSWORD_LENGTH = 8

fun isCorrectName(name: String) = name.isNotEmpty()

fun isCorrectMail(mail: String): Boolean =
    mail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()

fun isCorrectPassword(password: String): Boolean =
    password.isNotEmpty() && password.length > MIN_PASSWORD_LENGTH

fun isCorrectCheckPassword(password: String, checkPassword: String) =
    password.isNotEmpty() && password == checkPassword
