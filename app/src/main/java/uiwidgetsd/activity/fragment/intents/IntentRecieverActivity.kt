package uiwidgetsd.activity.fragment.intents

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityIntentRecieverBinding

class IntentRecieverActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentRecieverBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_reciever)

        binding = ActivityIntentRecieverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val strName: String? = intent.getStringExtra("name")
        binding.textName.text = "Welcome! $strName"
    }

}