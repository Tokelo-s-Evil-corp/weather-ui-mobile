package com.example.reboot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HourlyRow(
    time: List<Double>,
    icon: List<Double>,
    temperature: List<Double>
){
    LazyRow (
        modifier = Modifier.fillMaxWidth()
            .padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        items(time.size){ index ->
            HourlyCard(
                time = time[index].toString(),
                icon = icon[index].toString(),
                temperature = temperature[index].toString()
            )
        }
    }
}