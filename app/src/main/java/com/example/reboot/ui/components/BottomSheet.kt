package com.example.reboot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reboot.model.TimeConverter
import com.example.reboot.model.WeatherData
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet(data: WeatherData){
    var showBottomSheet by remember { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    val time = data.hourly.time
    val timeList: List<LocalTime> = time.map { TimeConverter(it) }
    val windSpeedList = data.hourly.wind_speed_10m
    ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                sheetState = sheetState,
                onDismissRequest = {showBottomSheet = false}
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                        .padding(0.dp,4.dp,0.dp,4.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val space = 8.dp
                    item {
                        HourlyRow(
                            time = data.hourly.temperature_2m,
                            icon = data.hourly.temperature_2m,
                            temperature = data.hourly.temperature_2m
                        )
                        Spacer(modifier = Modifier.height(space))
                    }

                    item {
                        TodayWindSpeedChart(timeList,windSpeedList)
                        Spacer(modifier = Modifier.height(space))
                    }
                }

            }

}

