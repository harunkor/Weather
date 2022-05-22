package com.reappear.weather.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("count")
    @Expose
    val count: Int,

    @SerializedName("data")
    @Expose
    val data: List<Data>
)