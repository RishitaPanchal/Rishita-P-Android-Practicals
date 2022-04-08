package com.example.uiwidgets

import architecture.mvc.MVCCardView
import architecture.mvp.CardMVP
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityArchitectureNavigationBinding

class ArchitectureNavigation : AppCompatActivity() {
    private lateinit var binding: ActivityArchitectureNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architecture_navigation)
        binding = ActivityArchitectureNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val i = Intent(this, CardMVP::class.java)
            startActivity(i)
        }

        binding.btn2.setOnClickListener {
            val i = Intent(this, MVCCardView::class.java)
            startActivity(i)
        }
    }
}