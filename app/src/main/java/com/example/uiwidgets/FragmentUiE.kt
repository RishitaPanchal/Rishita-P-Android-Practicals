package com.example.uiwidgets

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import webServices.ListUsersManualJsonParse
import com.example.kotlin_java_practicalss.databinding.FragmentUiEBinding
import com.example.kotlin_java_practicalss.databinding.HorizontalListItemBinding
import uiwidgetse.searchview.nestedscrollview.*

import webServices.LoginSignup

class FragmentUiE : Fragment(), View.OnClickListener {

    /** Instance variable */
    private lateinit var binding: FragmentUiEBinding

    /** Overriden metjods */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUiEBinding.inflate(layoutInflater)
        binding.click = this
        return binding.root
    }

    /** onCLick using Databinding */
    @SuppressLint("SetJavaScriptEnabled")
    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btn1.id -> {
                requireActivity().run {
                    startActivity(Intent(this, LoginSignup::class.java))
                }
            }
            binding.btn2.id -> {
                requireActivity().run {
                    startActivity(Intent(this, ListUsersManualJsonParse::class.java))
                }
            }
            binding.btn3.id -> {
                requireActivity().run {
                    startActivity(Intent(this, SearchviewInRecyclerview::class.java))
                }
            }
            binding.btn4.id -> {
                requireActivity().run {
                    startActivity(Intent(this, Webview::class.java))
                }
            }
            binding.btn5.id -> {
                requireActivity().run {
                    startActivity(Intent(this, NestedScrollview::class.java))
                }
            }
            binding.btn6.id -> {
                requireActivity().run {
                    startActivity(Intent(this, SearchviewInHorizontalList::class.java))
                }
            }
            binding.btn7.id -> {
                requireActivity().run {
                    startActivity(Intent(this, ScrollviewInsideNestedScrollview::class.java))
                }
            }

            binding.btn8.id -> {
                requireActivity().run {
                    startActivity(Intent(this, SearchviewInToolbar::class.java))
                }
            }
        }
    }

}