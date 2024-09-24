package com.example.reboot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reboot.model.codeList
import com.example.reboot.model.dateHourFilter
import com.example.reboot.model.todayListFilter

@Composable
fun HourlyRow(
    time: List<String>,
    weatherCodes: List<Int>,
    temperature: List<Double>,
    tempUnit: String
){
    val hourList = dateHourFilter(time)
    val tempList = todayListFilter(temperature)
    val iconList = codeList(weatherCodes,time)

    LazyRow(
        modifier = Modifier.fillMaxWidth()
            .padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        items(hourList.size){ index ->
            HourlyCard(
                time = hourList[index],
                icon = iconList[index],
                temperature = "${tempList[index]}$tempUnit"
            )
        }
    }
}