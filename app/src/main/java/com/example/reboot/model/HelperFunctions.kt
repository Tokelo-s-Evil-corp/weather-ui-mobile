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


fun hourlyRowIcon(weatherCode: Int, time: String): Int {
    val timeOfDate = TimeConverter(time).hour
    //check for day or night
    return if (timeOfDate in 17..23 || timeOfDate in 0..5) {
        when (weatherCode) {
            in 0..1 -> R.drawable.icons8_full_moon_96
            in 2..3 -> R.drawable.icons8_night_96
            in 45..48 -> R.drawable.icons8_fog_96
            in 51..67 -> R.drawable.icons8_rainy_night_96
            in 71..77 -> R.drawable.icons8_snow_96
            in 80..82 -> R.drawable.icons8_rain_96
            in 85..86 -> R.drawable.icons8_snow_96
            else -> R.drawable.icons8_wind_96
        }

    } else {
        when (weatherCode) {
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
}

fun DayNightPicture(time: String): Int{
    val timeOfDate = TimeConverter(time).hour

   return when(timeOfDate) {
        in 17..23 -> R.drawable.digital_art_character_looking_moon
        in 0..5 -> R.drawable.digital_art_character_looking_moon
        else -> R.drawable.anime_style_clouds
    }
}

fun codeList(weatherCode: List<Int>, timeList: List<String>): List<Int>{
    val reduced = weatherCode.take(24)
    val x : List<Int> = reduced.zip(timeList){code, time -> hourlyRowIcon(weatherCode = code, time )}
    return x
}