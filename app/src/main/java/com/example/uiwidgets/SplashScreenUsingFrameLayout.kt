package com.example.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.kotlin_java_practicalss.R

class SplashScreenUsingFrameLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_using_frame_layout)

        Handler().postDelayed({
            val intent = Intent(this, LayoutsDemo::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

}