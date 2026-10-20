package uz.muu.weatherpatterns.mvi.model

import uz.muu.weatherpatterns.data.model.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String? = null,
)

