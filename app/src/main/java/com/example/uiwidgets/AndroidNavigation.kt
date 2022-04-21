package com.example.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_practicalss.databinding.ActivityAndroidNavigationBinding
import design.support.library.CoordinatorLayout
import design.support.library.NavigationView
import permission.model.CameraStoragePermission
import permission.model.MultiplePermissions
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

        binding.btn5.setOnClickListener {
            val i = Intent(this, MultiplePermissions::class.java)
            startActivity(i)
        }

        binding.btn6.setOnClickListener {
            val i = Intent(this, NavigationView::class.java)
            startActivity(i)
        }

        binding.btn7.setOnClickListener {
            val i = Intent(this, CoordinatorLayout::class.java)
            startActivity(i)
        }
    }

}