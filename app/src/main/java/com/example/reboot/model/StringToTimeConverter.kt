package com.example.reboot.model

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

fun TimeConverter(date: String) : LocalTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val localDateTime = LocalTime.parse(date, formatter)
    return localDateTime
}