package com.example.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_practicalss.databinding.ActivityAndroidNavigationBinding
import permission.model.CameraStoragePermission
import permission.model.RuntimePermissionModel

class AndroidNavigation : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val i = Intent(this, TabbedApp::class.java)
            startActivity(i)
        }

        binding.btn2.setOnClickListener {
            val i = Intent(this, ArchitectureNavigation::class.java)
            startActivity(i)
        }

        binding.btn3.setOnClickListener {
            val i = Intent(this, RuntimePermissionModel::class.java)
            startActivity(i)
        }

        binding.btn4.setOnClickListener {
            val i = Intent(this, CameraStoragePermission::class.java)
            startActivity(i)
        }
    }

}