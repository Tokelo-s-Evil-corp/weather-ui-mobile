package com.example.reboot.ui.screens

import com.example.reboot.network.WeatherApi



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reboot.model.WeatherData


import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * UI state for the Home screen
 */
sealed interface WeatherUiState {
    data class Success(val response: WeatherData) : WeatherUiState
    object Error : WeatherUiState
    object Loading : WeatherUiState
}

class WeatherViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var weatherUiState: WeatherUiState by mutableStateOf(WeatherUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getWeatherData()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getWeatherData() {
        viewModelScope.launch {
            weatherUiState = WeatherUiState.Loading
            weatherUiState = try {
                val data = WeatherApi.retrofitService.getPhotos()
                WeatherUiState.Success(data)
            } catch (e: Exception) {
                WeatherUiState.Error
            } catch (e: HttpException) {
                WeatherUiState.Error
            }
        }
    }
}
