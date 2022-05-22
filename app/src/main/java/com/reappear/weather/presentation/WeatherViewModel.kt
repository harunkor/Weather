package com.reappear.weather.presentation

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.reappear.weather.domain.model.WeatherModel
import com.reappear.weather.domain.usecase.LocationUsecase
import com.reappear.weather.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase,
    private val locationUsecase: LocationUsecase
) : ViewModel() {

    val location:LiveData<Location>

    init {
        location = locationUsecase.getLocation
    }

    fun getWeather(city: String): LiveData<WeatherModel> {
        weatherUseCase.getWeather(city)
        return weatherUseCase.getCurrenWeather
    }

    fun getLatLonWeather(lat: String, lon: String): LiveData<WeatherModel> {
        weatherUseCase.getLatLonWeather(lat, lon)
        return weatherUseCase.getCurrenWeather
    }

    fun getLastKnownLocation() {
        locationUsecase.getLastLocation()
    }

}