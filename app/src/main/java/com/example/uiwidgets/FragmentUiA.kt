package com.example.uiwidgets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_java_practicalss.databinding.FragmentUiABinding

class FragmentUiA : Fragment() {

    private var _binding: FragmentUiABinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUiABinding.inflate(inflater, container, false)

        binding?.btn1?.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, UIWidgetsA::class.java))
            }
        }
        binding?.btn2?.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, IMEOption::class.java))
            }
        }
        binding?.btn3?.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, RippleEffect::class.java))
            }
        }
        return _binding!!.root
    }

}