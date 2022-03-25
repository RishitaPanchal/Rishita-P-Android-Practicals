package com.example.uiwidgets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import webServices.ListUsersManualJsonParse
import com.example.kotlin_java_practicalss.databinding.FragmentUiEBinding
import webServices.LoginSignup

class FragmentUiE : Fragment() {
    private lateinit var binding: FragmentUiEBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUiEBinding.inflate(layoutInflater)

        binding.btn1.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, LoginSignup::class.java))
            }
        }
        binding.btn2.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ListUsersManualJsonParse::class.java))
            }
        }
        return binding.root
    }

}