package com.example.reboot.model
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    val time: String,
    val interval: Int,
    val temperature_2m: Double,
    val wind_speed_10m: Double,
    val relative_humidity_2m: Int,
    val precipitation: Double,
    val precipitation_probability: Int,
    val weather_code: Int,
    val wind_direction_10m: Int,
    val apparent_temperature: Double,
    val cloud_cover: Int,
)

@Serializable
data class CurrentUnits(
    val time: String,
    val interval: String,
    val temperature_2m: String,
    val wind_speed_10m: String,
    val relative_humidity_2m: String,
    val precipitation: String,
    val precipitation_probability: String,
    val weather_code: String,
    val wind_direction_10m: String,
    val apparent_temperature: String,
    val cloud_cover: String,
)

@Serializable
data class Hourly(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val wind_speed_10m: List<Double>,
    val relative_humidity_2m: List<Int>,
    val precipitation: List<Double>,
    val precipitation_probability: List<Int>,
    val weather_code: List<Int>,
)

@Serializable
data class HourlyUnits(
    val time: String,
    val interval: String,
    val temperature_2m: String,
    val wind_speed_10m: String,
    val relative_humidity_2m: String,
    val precipitation: String,
    val precipitation_probability: String,
    val weather_code: String,
)

@Serializable
data class WeatherData(
    val current: Current,
    val current_units: CurrentUnits,
    val hourly: Hourly,
    val hourly_units: HourlyUnits
)
