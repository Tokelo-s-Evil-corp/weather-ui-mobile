package com.example.reboot.ui






import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reboot.ui.screens.HomeScreen
import com.example.reboot.ui.screens.WeatherViewModel


@Composable
fun WeatherApp(modifier: Modifier = Modifier) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),

    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val weatherViewModel: WeatherViewModel = viewModel()
            HomeScreen(
                weatherUiState = weatherViewModel.weatherUiState,
                contentPadding = it
            )
        }
    }
}

