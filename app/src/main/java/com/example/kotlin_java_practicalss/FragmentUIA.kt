package com.example.kotlin_java_practicalss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup

class FragmentUIA : Fragment() {

//    private lateinit var binding: Fragm
//    private var _binding: FragmentU = null
//    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        _binding = fragment_ui_a.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_ui_a, container, false)
    }


}