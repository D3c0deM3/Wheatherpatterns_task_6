package uz.muu.weatherpatterns.mvp

import uz.muu.weatherpatterns.data.model.Weather

interface WeatherContract {
    interface View {
        fun showLoading()
        fun showWeather(weather: Weather)
        fun showError(message: String)
    }
}