package com.reappear.weather.data.repository

import com.reappear.weather.data.source.remote.ApiService
import com.reappear.weather.domain.model.WeatherModel
import com.reappear.weather.domain.repository.WeatherRepository
import retrofit2.Call

class WeatherRepositoryImp(
    private val apiService: ApiService,
) : WeatherRepository {

    override fun getCurrent(city: String, key: String): Call<WeatherModel> {
        return apiService.getWeather(city, key)
    }

    override fun getLatLon(lat: String, lon: String, key: String): Call<WeatherModel> {
        return apiService.getLatLon(lat, lon, key)
    }
}