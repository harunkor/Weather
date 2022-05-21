package com.reappear.androidcleanarchitecturemvvmbasicsample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reappear.androidcleanarchitecturemvvmbasicsample.domain.model.WeatherModel
import com.reappear.androidcleanarchitecturemvvmbasicsample.domain.usecase.WeatherUseCase
import com.reappear.weather.utils.Constants.Companion.KEY_API
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val useCase: WeatherUseCase):ViewModel() {

    fun getWeather(city:String): LiveData<WeatherModel> {
        useCase.getWeather(city)
        return useCase.getCurrenWeather
    }

}