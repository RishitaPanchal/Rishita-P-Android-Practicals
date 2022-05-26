package com.example.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin_java_practicalss.databinding.ActivityAndroidNavigationBinding
import dependancy.injection.DIViewActivity

class AndroidNavigation : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAndroidNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btn1.id -> startActivity(Intent(this, TabbedApp::class.java))
            binding.btn2.id -> startActivity(Intent(this, ArchitectureNavigation::class.java))
            binding.btn3.id -> startActivity(Intent(this, DIViewActivity::class.java))
        }
    }

}