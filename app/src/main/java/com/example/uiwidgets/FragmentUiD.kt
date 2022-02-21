package com.example.uiwidgets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityUiwidgetsDBinding
import com.example.kotlin_java_practicalss.databinding.FragmentUiCBinding
import com.example.kotlin_java_practicalss.databinding.FragmentUiDBinding
import uiwidgetsc.listview.recyclerview.adapters.*
import uiwidgetsd.activity.fragment.intents.*

class FragmentUiD : Fragment() {

    private lateinit var binding: FragmentUiDBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUiDBinding.inflate(layoutInflater)
        binding.btn1.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ActivityLifecycleDemo::class.java))
            }
        }
        binding.btn2.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, LMSIntentDemo::class.java))
            }
        }
        binding.btn3.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, FragmentTransactions::class.java))
            }
        }
        binding.btn4.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ExercisePractical1UsingViewmodel::class.java))
            }
        }
        binding.btn5.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, FragmentContainerViewDemo::class.java))
            }
        }
        binding.btn6.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, Practical2::class.java))
            }
        }
        binding.btn7.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, IntentFIlterToRecieveData::class.java))
            }
        }
        binding.btn8.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, PendingIntentDemo::class.java))
            }
        }
        return binding.root
    }

}