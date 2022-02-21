package uiwidgetsd.activity.fragment.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityLmsintentDemoBinding
import java.lang.Exception

class LMSIntentDemo : AppCompatActivity() {

    private lateinit var binding: ActivityLmsintentDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lmsintent_demo)

        binding = ActivityLmsintentDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val intent = Intent(this, IntentRecieverActivity::class.java)
            val name = binding.edittextName.text.toString()
            intent.putExtra("name", name)
            try {
                startActivity(intent)
            } catch (E: Exception) {
                Log.d("Exception", "Could not found an activity")
            }
        }
        binding.btn2.setOnClickListener {
            val url = binding.url.text
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://$url"))
            try {
                startActivity(intent)
            } catch (E: Exception) {
                Log.d("Exception", "Could not found an activity")
            }
        }
        binding.btn3.setOnClickListener {
            val msg = binding.textToSend.text.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, msg)
            intent.type = "text/plain"
            try {
                startActivity(Intent.createChooser(intent, "Choose an app:"))
            } catch (E: Exception) {
                Log.d("Exception", "Could not found an activity")
            }
        }
        binding.btn4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:23.033279,72.460358"))
            try {
                startActivity(Intent.createChooser(intent, "Choose an app:"))
            } catch (E: Exception) {
                Log.d("Exception", "Could not found an activity")
            }
        }
    }

}