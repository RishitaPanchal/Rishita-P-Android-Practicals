package com.example.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val intent = Intent(this, UIWidgetsA::class.java)
            startActivity(intent)
        }

        binding.btn2.setOnClickListener {
            val intent = Intent(this, IMEOption::class.java)
            startActivity(intent)
        }

        binding.btn3.setOnClickListener {
            val intent = Intent(this, LayoutsDemo::class.java)
            startActivity(intent)
        }
        binding.btn4.setOnClickListener {
            val intent = Intent(this, Ripple_Effect::class.java)
            startActivity(intent)
        }

    }
    
}