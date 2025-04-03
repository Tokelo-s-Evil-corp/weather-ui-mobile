package com.example.reboot.ui






import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reboot.ui.screens.HomeScreen
import com.example.reboot.ui.screens.WeatherViewModel


@Composable
fun WeatherApp(modifier: Modifier = Modifier) {

    val weatherViewModel: WeatherViewModel = viewModel()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                shape = RoundedCornerShape(23.dp),
                onClick = { weatherViewModel.getWeatherData() },
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 2.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Spacer(Modifier.width(4.dp))
                    Icon(
                        Icons.Outlined.Refresh,
                        contentDescription = ""
                    )
                }
            }
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen(
                weatherUiState = weatherViewModel.weatherUiState,
                contentPadding = it
            )
        }
    }
}

