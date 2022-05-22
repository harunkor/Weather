package com.reappear.weather.di

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.reappear.weather.domain.repository.WeatherRepository
import com.reappear.weather.data.repository.LocationRepositoryImp
import com.reappear.weather.data.repository.WeatherRepositoryImp
import com.reappear.weather.data.source.remote.ApiService
import com.reappear.weather.domain.repository.LocationRepository
import com.reappear.weather.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build();

    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideWeatherRepository(apiService: ApiService): WeatherRepository {
        return WeatherRepositoryImp(apiService)
    }


    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(@ApplicationContext appContext: Context): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(appContext)
    }


    @Provides
    @Singleton
    @SuppressLint("MissingPermission")
    fun provideLocation(fusedLocationProviderClient: FusedLocationProviderClient): Task<Location> {
        return fusedLocationProviderClient.lastLocation.addOnSuccessListener { }
    }


    @Provides
    @Singleton
    fun provideLocationRepository(location: Task<Location>): LocationRepository {
        return LocationRepositoryImp(location)
    }


}