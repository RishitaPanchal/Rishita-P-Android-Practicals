package com.example.uiwidgets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_java_practicalss.databinding.FragmentUiCBinding
import uiwidgetsc.listview.recyclerview.adapters.*

class FragmentUiC : Fragment() {

    private var _binding: FragmentUiCBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUiCBinding.inflate(inflater, container, false)

        binding.btn1.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, SimpleListView::class.java))
            }
        }
        binding.btn2.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ListviewWithImage::class.java))
            }
        }
        binding.btn3.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, SimpleRecyclerview::class.java))
            }
        }
        binding.btn4.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, StrageredGridviewRecyclerview::class.java))
            }
        }
        binding.btn5.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ExpandableListvieww::class.java))
            }
        }
        binding.btn6.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ExpandableRecyclerview::class.java))
            }
        }
        binding.btn7.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ViewpagerDemo::class.java))
            }
        }
        binding.btn8.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, BottomNavigationWithViewpager::class.java))
            }
        }
        binding.btn9.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, Viewpager2Demo::class.java))
            }
        }
        return _binding!!.root
    }

}