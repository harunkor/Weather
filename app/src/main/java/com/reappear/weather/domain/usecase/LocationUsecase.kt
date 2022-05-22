package com.reappear.weather.domain.usecase

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reappear.weather.domain.repository.LocationRepository
import javax.inject.Inject

class LocationUsecase @Inject constructor(private val locationRepository: LocationRepository) {

    private var getLocationTemp = MutableLiveData<Location>()
    val getLocation: LiveData<Location> = getLocationTemp

    fun getLastLocation() {
        locationRepository.getLocation().addOnSuccessListener {
            it ?: return@addOnSuccessListener
            getLocationTemp.value = it
        }
    }


}