package com.reappear.weather.domain.repository

import com.reappear.weather.domain.model.WeatherModel
import retrofit2.Call

interface WeatherRepository {

    fun getCurrent(city: String, key: String): Call<WeatherModel>
    fun getLatLon(lat: String, lon: String, key: String): Call<WeatherModel>

}

