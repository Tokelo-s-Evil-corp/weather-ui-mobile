package com.example.reboot.model
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    val time: String,
    val interval: Int,
    val temperature_2m: Double,
    val wind_speed_10m: Double,
    val relative_humidity_2m: Int
)

@Serializable
data class CurrentUnits(
    val time: String,
    val interval: String,
    val temperature_2m: String,
    val wind_speed_10m: String,
    val relative_humidity_2m: String
)

@Serializable
data class Hourly(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val wind_speed_10m: List<Double>,
    val relative_humidity_2m: List<Int>
)

@Serializable
data class HourlyUnits(
    val time: String,
    val interval: String,
    val temperature_2m: String,
    val wind_speed_10m: String,
    val relative_humidity_2m: String
)

@Serializable
data class WeatherData(
    val current: Current,
    val current_units: CurrentUnits,
    val hourly: Hourly,
    val hourly_units: HourlyUnits
)
