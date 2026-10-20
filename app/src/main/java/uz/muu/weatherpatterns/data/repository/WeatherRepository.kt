package uz.muu.weatherpatterns.data.repository

import uz.muu.weatherpatterns.data.api.WeatherApi
import uz.muu.weatherpatterns.data.model.Weather

class WeatherRepository(
    private val api: WeatherApi
) {
    suspend fun getWeather(city: String): Result<Weather> {
        return try {
            Result.success(api.fetchWeather(city))
        } catch (e: IllegalArgumentException) {
            Result.failure(e)
        }
    }
}