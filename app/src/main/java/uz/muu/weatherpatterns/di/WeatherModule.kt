package uz.muu.weatherpatterns.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import uz.muu.weatherpatterns.data.api.FakeWeatherApi
import uz.muu.weatherpatterns.data.repository.WeatherRepository
import uz.muu.weatherpatterns.mvi.viewmodel.WeatherMviViewModel
import uz.muu.weatherpatterns.mvvm.viewmodel.WeatherViewModel

object WeatherModule
{
    // Three seconds leaves time to rotate the device while loading.
    val repository = WeatherRepository(FakeWeatherApi(latencyMs = 3_000))

    val weatherViewModelFactory: ViewModelProvider.Factory = viewModelFactory()
    {
        initializer()
        {
            WeatherViewModel(repository)
        }
    }

    val weatherMviViewModelFactory: ViewModelProvider.Factory = viewModelFactory()
    {
        initializer()
        {
            WeatherMviViewModel(repository)
        }
    }
}


