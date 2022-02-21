package uiwidgetsd.activity.fragment.intents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityFragmentContainerViewDemoBinding
import com.example.kotlin_java_practicalss.databinding.ActivityIntentFilterToRecieveDataBinding

class IntentFIlterToRecieveData : AppCompatActivity() {

    private lateinit var binding: ActivityIntentFilterToRecieveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_filter_to_recieve_data)

        binding = ActivityIntentFilterToRecieveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.action == Intent.ACTION_SEND) {
            if (intent.type?.startsWith("text/") == true) {
                urlSend(intent)
            } else if (intent.type?.startsWith("image/") == true) {
                imageSend(intent)
            }
        }
    }

    private fun urlSend(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            binding.textView2.text = it
        }
    }

    private fun imageSend(intent: Intent) {
        (intent.getParcelableExtra(Intent.EXTRA_STREAM) as? Uri)?.let {
            binding.imgHolder1.setImageURI(it)
        }
    }

}