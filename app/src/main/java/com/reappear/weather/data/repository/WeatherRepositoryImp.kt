package com.reappear.androidcleanarchitecturemvvmbasicsample.data.repository

import androidx.lifecycle.MutableLiveData
import com.reappear.androidcleanarchitecturemvvmbasicsample.data.source.remote.ApiService
import com.reappear.androidcleanarchitecturemvvmbasicsample.domain.model.WeatherModel
import com.reappear.androidcleanarchitecturemvvmbasicsample.domain.repository.WeatherRepository
import retrofit2.Call

class WeatherRepositoryImp(private val apiService: ApiService) :WeatherRepository {
    override fun getCurrent(city: String, key: String): Call<WeatherModel> {
        return apiService.getWeather(city,key)
    }


}