package com.example.uiwidgets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.FragmentUiBBinding


class FragmentUiB : Fragment() {
    private var _binding: FragmentUiBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUiBBinding.inflate(inflater, container, false)
        //Button 4 (Instagram design) contains  following layouts:
        /*
            Home page has implementaion of <include> tag
            Linear (Home page)
            Relative (Direct message page)
            Grid (Explore page)
            Frame (SPlash screen)
         */

        binding.btn4.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, SplashScreenUsingFrameLayout::class.java))
            }
        }
        binding.btn5.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ConstraintLayoutForm::class.java))
            }
        }
        binding.btn6.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, MergetagImplementation::class.java))
            }
        }
        binding.btn7.setOnClickListener {
            Toast.makeText(context, getString(R.string.toast_msg), Toast.LENGTH_LONG).show()
        }
        binding.btn8.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, TableLayoutDemo::class.java))
            }
        }
        return _binding!!.root
    }
}