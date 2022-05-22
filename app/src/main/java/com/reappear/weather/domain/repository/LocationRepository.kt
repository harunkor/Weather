package com.reappear.weather.domain.repository


import android.location.Location
import com.google.android.gms.tasks.Task

interface LocationRepository {
    fun getLocation(): Task<Location>
}