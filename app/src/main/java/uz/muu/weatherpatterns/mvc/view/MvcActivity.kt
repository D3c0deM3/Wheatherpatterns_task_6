package uz.muu.weatherpatterns.mvc.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import uz.muu.weatherpatterns.di.WeatherModule
import uz.muu.weatherpatterns.mvc.controller.WeatherController
import uz.muu.weatherpatterns.mvc.model.WeatherModel
import uz.muu.weatherpatterns.ui.WeatherScreen

class MvcActivity : ComponentActivity(), WeatherView {

    private val model = WeatherModel(WeatherModule.repository)
    private val controller = WeatherController(model, view = this)
    private var status by mutableStateOf("Pick a city")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WeatherScreen(status = status, onCitySelected = controller::onCitySelected)
            }
        }
    }

    override fun render()
    {
        status = when
        {
            model.isLoading -> "Loading…"
            model.error != null -> "Error: ${model.error}"
            model.weather != null ->
            {
                val w = model.weather!!
                "${w.city}: ${w.temperatureC}°C, ${w.condition}"
            }

            else -> "Pick a city"
        }
    }
}