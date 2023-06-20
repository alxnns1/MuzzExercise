package com.alxnns1.muzzexercise.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtil {

    fun timestampToDateTimeString(timestamp: Long): String {
        val dateFormat = SimpleDateFormat("EEEE HH:mm", Locale.getDefault())
        return dateFormat.format(Date(timestamp))
    }
}