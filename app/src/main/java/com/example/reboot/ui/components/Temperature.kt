package com.example.reboot.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.reboot.ui.theme.RebootTheme

@Composable
fun TemperatureCard (dataTemp: String, units: String, modifier: Modifier = Modifier){
    Column {
        Text(text = "$dataTemp$units")
    }
}

@Composable
@Preview
fun TempPreview(){
    RebootTheme {
        TemperatureCard(dataTemp = "18","°C")
    }
}

