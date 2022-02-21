package uiwidgetsd.activity.fragment.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityUiwidgetsDBinding

class UiwidgetsD : AppCompatActivity() {

    private lateinit var binding: ActivityUiwidgetsDBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uiwidgets_d)
        binding = ActivityUiwidgetsDBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val i = Intent(this, ActivityLifecycleDemo::class.java)
            startActivity(i)
        }
        binding.btn2.setOnClickListener {
            val i = Intent(this, LMSIntentDemo::class.java)
            startActivity(i)
        }
        binding.btn3.setOnClickListener {
            val i = Intent(this, FragmentTransactions::class.java)
            startActivity(i)
        }
        binding.btn4.setOnClickListener {
            val i = Intent(this, ExercisePractical1UsingViewmodel::class.java)
            startActivity(i)
        }
        binding.btn5.setOnClickListener {
            val i = Intent(this, FragmentContainerViewDemo::class.java)
            startActivity(i)
        }
        binding.btn6.setOnClickListener {
            val i = Intent(this, Practical2::class.java)
            startActivity(i)
        }
        binding.btn7.setOnClickListener {
            val i = Intent(this, IntentFIlterToRecieveData::class.java)
            startActivity(i)
        }
        binding.btn8.setOnClickListener {
            val i = Intent(this, PendingIntentDemo::class.java)
            startActivity(i)
        }
    }
}