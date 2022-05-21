package com.reappear.androidcleanarchitecturemvvmbasicsample.domain.repository

import androidx.lifecycle.MutableLiveData
import com.reappear.androidcleanarchitecturemvvmbasicsample.domain.model.WeatherModel
import retrofit2.Call

interface WeatherRepository {

    fun getCurrent(city: String, key:String) : Call<WeatherModel>

}

