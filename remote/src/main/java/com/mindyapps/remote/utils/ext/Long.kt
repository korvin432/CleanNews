package com.mindyapps.remote.utils.ext

import java.text.SimpleDateFormat
import java.util.*

fun Long.parseDate(pattern: String = "dd.MM.yyyy", locale: String = "eng"): String {
    val format = SimpleDateFormat(pattern, Locale(locale))
    return format.format(this * 1000)
}