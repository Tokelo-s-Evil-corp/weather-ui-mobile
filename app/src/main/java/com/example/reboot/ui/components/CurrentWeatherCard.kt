package com.example.reboot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reboot.R
import com.example.reboot.ui.screens.ResultScreen

@Composable
fun CurrentWeather(
    humidity: String,
    windSpeed: String,
    humidityUnit: String,
    windSpeedUnit: String,
    humidityLabel: String,
    windSpeedLabel: String,
){
    OutlinedCard(
        modifier = Modifier.size(380.dp,120.dp),
        shape = RoundedCornerShape(80.dp),
    ) {
        val windSpeedIconID = R.drawable.icons8_wind_96
        val humidityIconID = R.drawable.icons8_wet_96
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatColumn(iconId = humidityIconID, stat = humidity, unit = humidityUnit, label = humidityLabel)

            StatColumn(iconId = windSpeedIconID, stat = windSpeed, unit = windSpeedUnit, label = windSpeedLabel)
        }
    }
}

@Composable
fun StatColumn(
    iconId: Int,
    stat: String,
    unit: String,
    label: String,
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = iconId), contentDescription = "", Modifier.size(32.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "$stat$unit", fontSize = 16.sp)
        Text(text = label, fontSize = 12.sp)
    }
}