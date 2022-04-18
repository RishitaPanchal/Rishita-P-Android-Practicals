package com.example.uiwidgets

import coroutines.CoroutinesScopeDemo
import architecture.mvp.CardMVP
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import architecture.bindingadapters.LoadImageView
import architecture.mvc.MVCCardView
import architecture.mvvm.MVVMCardView
import architecture.viewmodelfactory.ViewModelFactoryDemo
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
        binding.btn3.setOnClickListener {
            val i = Intent(this, MVVMCardView::class.java)
            startActivity(i)
        }
        binding.btn4.setOnClickListener {
            val i = Intent(this, LoadImageView::class.java)
            startActivity(i)
        }
        binding.btn5.setOnClickListener {
            val i = Intent(this, ViewModelFactoryDemo::class.java)
            startActivity(i)
        }
        binding.btn6.setOnClickListener {
            val i = Intent(this, CoroutinesScopeDemo::class.java)
            startActivity(i)
        }
    }
}