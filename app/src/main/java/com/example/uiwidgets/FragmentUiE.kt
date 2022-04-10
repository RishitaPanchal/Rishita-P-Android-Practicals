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

class FragmentUiE : Fragment(), View.OnClickListener {

    /** Instance variable */
    private lateinit var binding: FragmentUiEBinding

    /** Overridden method */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUiEBinding.inflate(layoutInflater)
        binding.click = this
        return binding.root
    }

    // Onclick using data binding
    override fun onClick(p0: View?) {
       when(p0?.id) {
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
       }
    }

}