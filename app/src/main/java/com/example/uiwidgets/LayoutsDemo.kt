package com.example.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityLayoutsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LayoutsDemo : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout_demo)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_fragment)
        bottomNavigationView.setupWithNavController(navController)
    }

}