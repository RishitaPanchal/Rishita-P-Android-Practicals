package com.example.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityConstraintLayoutForm2Binding
import com.example.kotlin_java_practicalss.databinding.ActivityImeoptionBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ConstraintLayoutForm : AppCompatActivity() {
    private lateinit var binding: ActivityConstraintLayoutForm2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout_form2)
        binding = ActivityConstraintLayoutForm2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intrest = resources.getStringArray(R.array.intrested_in)
        val arrayAdapter = ArrayAdapter(this, R.layout.list_item, intrest)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.send.setOnClickListener {
            if (binding.name.text.toString().isEmpty()) {
                Toast.makeText(this, "Name feild is empty!!", Toast.LENGTH_LONG).show()
            }
            if (binding.email.text.toString().isEmpty()) {
                Toast.makeText(this, "Email feild is empty!!", Toast.LENGTH_LONG).show()
            }
            if (binding.company.text.toString().isEmpty()) {
                Toast.makeText(this, "Company feild is empty!!", Toast.LENGTH_LONG).show()
            }
            if (binding.message.text.toString().isEmpty()) {
                Toast.makeText(this, "Message feild is empty!!", Toast.LENGTH_LONG).show()
            }

            if(binding.name.text.toString().isNotEmpty() && binding.email.text.toString().isNotEmpty() && binding.company.text.toString().isNotEmpty() && binding.message.text.toString().isNotEmpty()) {   MaterialAlertDialogBuilder(this)
                    .setTitle("Thank you!! ${binding.name.text.toString()}")
                    .setMessage(resources.getString(R.string.message))
                    .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->
                        // Respond to positive button press
                    }
                    .show()
            }
        }
    }

}