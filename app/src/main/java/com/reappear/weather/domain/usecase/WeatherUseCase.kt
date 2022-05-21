package com.reappear.androidcleanarchitecturemvvmbasicsample.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reappear.androidcleanarchitecturemvvmbasicsample.domain.model.WeatherModel
import com.reappear.androidcleanarchitecturemvvmbasicsample.domain.repository.WeatherRepository
import com.reappear.weather.utils.Constants.Companion.KEY_API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository) {

    private var getCurrenWeatherTemp = MutableLiveData<WeatherModel>()
    val getCurrenWeather: LiveData<WeatherModel> = getCurrenWeatherTemp

    fun getWeather(city:String) {
        weatherRepository.getCurrent(city,KEY_API).enqueue(object : Callback<WeatherModel>{
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                getCurrenWeatherTemp.value = response.body()
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
              //  TODO("Not yet implemented")
            }

        })

    }



}