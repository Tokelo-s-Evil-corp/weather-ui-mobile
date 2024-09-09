package com.example.reboot.ui.screens




import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reboot.model.WeatherData
import com.example.reboot.ui.components.CurrentWeather
import com.example.reboot.ui.components.Location
import com.example.reboot.ui.components.PartialBottomSheet
import com.example.reboot.ui.components.TemperatureCard


@Composable
fun HomeScreen(
    weatherUiState: WeatherUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (weatherUiState) {
        is WeatherUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is WeatherUiState.Success -> ResultScreen(
            weatherUiState.response, modifier = modifier.fillMaxWidth()
        )
        is WeatherUiState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}

/**
 * The home screen displaying the loading message.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "Loading")
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Error")
    }
}

/**
 * ResultScreen displaying number of photos retrieved.
 */
@Composable
fun ResultScreen(data: WeatherData, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp, 20.dp)
    ) {
        Location()
        TemperatureCard(dataTemp = data.current.temperature_2m.toString(), units = data.current_units.temperature_2m)
        CurrentWeather(
            humidity = data.current.relative_humidity_2m.toString(),
            humidityIcon = data.current.relative_humidity_2m.toString(),
            windSpeed = data.current.wind_speed_10m.toString(),
            windSpeedIcon = data.current.wind_speed_10m.toString(),
            humidityUnit = data.current_units.relative_humidity_2m,
            windSpeedUnit = data.current_units.wind_speed_10m,
            humidityLabel = "Humidity",
            windSpeedLabel = "Wind Speed"
        )
        PartialBottomSheet(data)
    }
}

