package com.example.reboot.model

import com.example.reboot.R
import java.time.LocalTime

fun todayListFilter(list: List<Double>) : List<Double>{
    return list.take(24)
}

fun dateHourFilter(list: List<String>) : List<String>{
    val filtered = list.take(24)
    val timeList: List<LocalTime> = filtered.map { TimeConverter(it) }
    val hours: List<Int> = timeList.map{i ->  i.hour}
    val format: List<String> = hours.map { i -> when(i){
        in 0..9 -> "0${i}:00"
        else -> "${i}:00"
    } }
    return format
}


fun hourlyRowIcon(weatherCode: Int): Int{
    return when(weatherCode){
        in 0..1 -> R.drawable.icons8_summer_96
        2 -> R.drawable.icons8_partly_cloudy_day_96
        3 -> R.drawable.icons8_clouds_96
        in 45..48 -> R.drawable.icons8_fog_96
        in 51..67 -> R.drawable.icons8_rain_96
        in 71..77 -> R.drawable.icons8_snow_96
        in 80..82 -> R.drawable.icons8_rain_96
        in 85..86 -> R.drawable.icons8_snow_96
        else -> R.drawable.icons8_wind_96
    }
}

fun codeList(weatherCode: List<Int>): List<Int>{
    val reduced = weatherCode.take(24)
    val x : List<Int> = reduced.map{i -> hourlyRowIcon(weatherCode = i)}
    return x
}