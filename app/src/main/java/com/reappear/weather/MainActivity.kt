package com.reappear.weather

import android.os.Bundle
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var  bottomImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setBottomAnimation()





    }

    private fun  init(){
        bottomImageView = findViewById(R.id.bottomimage)

    }

    private  fun setBottomAnimation(){
        val animation = TranslateAnimation(0f, 0f, 50f, 40f)
        animation.duration = 1500
        bottomImageView.animation = animation


    }
}