package com.example.reboot.ui.screens




import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reboot.model.WeatherData
import com.example.reboot.ui.components.CurrentWeather
import com.example.reboot.ui.components.Location
import com.example.reboot.ui.components.PartialBottomSheetColumn
import com.example.reboot.ui.components.StagContainer
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
fun LoadingScreen(
    modifier : Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Loading")
    }
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(data: WeatherData, modifier: Modifier = Modifier) {
    var showBottomSheet by remember { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
    ) {
        item{
            Location()
        }
        item {
            TemperatureCard(
                dataTemp = data.current.temperature_2m.toString(),
                units = data.current_units.temperature_2m,
                data.current.weather_code,
                data.current.time
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        item{
            CurrentWeather(
                humidity = data.current.relative_humidity_2m.toString(),
                windSpeed = data.current.wind_speed_10m.toString(),
                humidityUnit = data.current_units.relative_humidity_2m,
                windSpeedUnit = data.current_units.wind_speed_10m,
                humidityLabel = "Humidity",
                windSpeedLabel = "Wind Speed",
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item{
            Spacer(modifier = Modifier.height(8.dp))
            StagContainer(
                data.current.time,
                data.current.wind_direction_10m,
                data.current_units.wind_direction_10m,
                data.current.cloud_cover,
                data.current_units.cloud_cover
            )
        }

        item {
            OutlinedButton(
                modifier = Modifier.size(148.dp,76.dp),
                onClick = { showBottomSheet = true },
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(text = "Show more")
            }
        }
        if (showBottomSheet) {
            item {
                ModalBottomSheet(
                    onDismissRequest = {showBottomSheet = false },
                    sheetState = sheetState,
                    modifier = Modifier.fillMaxSize()
                ) {
                    PartialBottomSheetColumn(data = data)
                }
            }
        }
    }
}

