package com.example.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityImeoptionBinding

class IMEOption : AppCompatActivity() {

    private lateinit var binding: ActivityImeoptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imeoption)
        binding = ActivityImeoptionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.password.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
               Toast.makeText(this,"Done", Toast.LENGTH_SHORT).show()
                true
            } else {
                Toast.makeText(this,"Next", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }



}