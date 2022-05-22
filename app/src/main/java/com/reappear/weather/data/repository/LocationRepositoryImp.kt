package com.reappear.weather.data.repository

import android.location.Location
import com.google.android.gms.tasks.Task
import com.reappear.weather.domain.repository.LocationRepository

class LocationRepositoryImp(private val location: Task<Location>) : LocationRepository {
    override fun getLocation(): Task<Location> {
        return location
    }
}