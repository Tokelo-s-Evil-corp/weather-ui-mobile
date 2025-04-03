package com.example.reboot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reboot.model.hourlyRowIcon
import com.example.reboot.ui.theme.RebootTheme

@Composable
fun TemperatureCard (dataTemp: String, units: String, weathercode: Int,time: String, modifier: Modifier = Modifier){
    val icon = hourlyRowIcon(weathercode,time)
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "$dataTemp$units", fontSize = 60.sp)
        Image(painter = painterResource(id = icon), contentDescription = "", Modifier.size(92.dp) )
    }
}


