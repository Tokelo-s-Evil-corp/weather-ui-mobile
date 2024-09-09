package com.example.reboot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CurrentWeather(
    humidity: String,
    humidityIcon: String,
    windSpeed: String,
    windSpeedIcon: String,
    humidityUnit: String,
    windSpeedUnit: String,
    humidityLabel: String,
    windSpeedLabel: String
){
    OutlinedCard(
        modifier = Modifier.size(380.dp,120.dp),
        shape = RoundedCornerShape(80.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatColumn(icon = humidityIcon, stat = humidity, unit = humidityUnit, label = humidityLabel)

            StatColumn(icon = windSpeedIcon, stat = windSpeed, unit = windSpeedUnit, label = windSpeedLabel)
        }
    }
}

@Composable
fun StatColumn(
    icon: String,
    stat: String,
    unit: String,
    label: String,
){
    Column(
//        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = icon, fontSize = 13.sp)
        Text(text = "$stat$unit", fontSize = 13.sp)
        Text(text = label, fontSize = 12.sp)
    }
}