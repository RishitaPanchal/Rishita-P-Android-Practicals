package com.example.uiwidgets

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.RadioButton
import android.widget.Toast
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityUiwidgetsBinding


class UIWidgetsA : AppCompatActivity() {
    private lateinit var binding: ActivityUiwidgetsBinding
    lateinit var radioButton: RadioButton
    private val result = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uiwidgets)
        binding = ActivityUiwidgetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layouut = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_wrap))

        binding.back.setOnClickListener {
            val intent = Intent(this, TabbedApp::class.java)
            startActivity(intent)
        }
        binding.signup.setOnClickListener {
            val email = binding.email.text.toString()
            val pass1 = binding.pass.text.toString()
            val checked = binding.radioGroup.checkedRadioButtonId
            radioButton = findViewById(checked)
            val gender = radioButton.text.toString()
            displayData(email, gender, pass1)
        }
        binding.simpleImageButton.setOnClickListener {
            Toast(this).also {
                it.duration = Toast.LENGTH_SHORT
                it.setGravity(Gravity.BOTTOM, 0, 0)
                it.view = layouut
            }.show()
        }
        binding.switch1.setOnCheckedChangeListener { compoundButton, onSwitch ->
            if(onSwitch) {
                binding.bg.setBackgroundColor(Color.rgb(224,233,233))
            } else {
                binding.bg.setBackgroundColor(Color.rgb(239,235,214))
            }
        }

    }

    private fun displayData(email: String, pass1: String, gender: String) {
        result.append("Email : $email \n")
        result.append("Gender: $gender \n")
        result.append("Cources :")

        if(binding.cplus.isChecked) {
            result.append("\n${binding.cplus.text}")
        }
        if(binding.java.isChecked) {
            result.append("\n${binding.java.text}")
        }
        if(binding.python.isChecked) {
            result.append("\n${binding.python.text}")
        }

        if (email.isEmpty() || pass1.isEmpty()) {
            Toast.makeText(this, "Fields should not be empty!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Entered details are : \n${result}", Toast.LENGTH_SHORT).show()
            result.clear()
        }
    }
}