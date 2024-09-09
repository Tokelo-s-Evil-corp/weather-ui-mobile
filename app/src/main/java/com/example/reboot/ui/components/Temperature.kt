package com.example.reboot.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.reboot.ui.theme.RebootTheme

@Composable
fun TemperatureCard (dataTemp: String, units: String, modifier: Modifier = Modifier){
    Column {
        Text(text = "$dataTemp$units", fontSize = 60.sp)
    }
}

@Composable
@Preview
fun TempPreview(){
    RebootTheme {
        TemperatureCard(dataTemp = "18","°C")
    }
}

