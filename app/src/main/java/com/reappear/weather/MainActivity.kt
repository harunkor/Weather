package com.reappear.weather

import android.os.Bundle
import android.util.Log
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.reappear.androidcleanarchitecturemvvmbasicsample.presentation.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<WeatherViewModel>()

    private lateinit var  bottomImageView: ImageView
    private lateinit var  bottomImageView2: ImageView
    private lateinit var  bottomImageView3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setBottomAnimation()


        mainViewModel.getWeather("Gaziantep").observe(this, Observer {
            Log.v("AKBANK",it.data?.get(0).toString())
        })


    }

    private fun  init(){
        bottomImageView = findViewById(R.id.bottomimage)
        bottomImageView2 = findViewById(R.id.bottomimage2)
        bottomImageView3 = findViewById(R.id.bottomimage3)

    }

    private  fun setBottomAnimation(){
        val animation = TranslateAnimation(0f, 0f, 50f, 40f)
        animation.duration = 1500
        bottomImageView.animation = animation
        bottomImageView2.animation = animation
        bottomImageView3.animation = animation



    }
}