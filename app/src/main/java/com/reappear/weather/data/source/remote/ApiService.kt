package com.reappear.weather.data.source.remote

import com.reappear.weather.domain.model.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current")
    fun getWeather(@Query("city") city: String, @Query("key") key: String): Call<WeatherModel>

    @GET("current")
    fun getLatLon(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("key") key: String
    ): Call<WeatherModel>

}