package com.reappear.weather

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.reappear.weather.databinding.ActivityMainBinding
import com.reappear.weather.presentation.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<WeatherViewModel>()
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this
        setBottomAnimation()
        funPermissionRequest()


          mainViewModel.getWeather("Gaziantep").observe(this, Observer {
              Log.v("AKBANK",it.data?.get(0).toString())
          })

        mainViewModel.location.observe(this, Observer {
            Log.v("AKBANK", it.toString())
          /*  mainViewModel.getLatLonWeather(it.latitude?.toString(), it.longitude?.toString())
                .observe(this, Observer {
                    Log.v("AKBANK", it.data?.get(0).toString())
                })*/
        })


    }

    private fun funPermissionRequest() {
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }

    private fun setBottomAnimation() {
        val animation = TranslateAnimation(0f, 0f, 50f, 40f)
        animation.duration = 1500
        activityMainBinding.bottomimage.animation = animation
        activityMainBinding.bottomimage2.animation = animation
        activityMainBinding.bottomimage3.animation = animation

    }

    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    mainViewModel.getLastKnownLocation()
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    mainViewModel.getLastKnownLocation()
                }
                else -> {

                }

            }
        } else {
            mainViewModel.getLastKnownLocation()
        }
    }


}