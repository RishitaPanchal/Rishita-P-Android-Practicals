package uiwidgetsd.activity.fragment.intents

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityLifecycleDemoBinding
//Activity lifecycle demo
class ActivityLifecycleDemo : AppCompatActivity() {

    private lateinit var binding: ActivityLifecycleDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_demo)
        binding = ActivityLifecycleDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        print("Oncreate()")
    }

    override fun onStart() {
        super.onStart()
        binding.textView.text = getString(R.string.onstart)
        print("Onstart()")
    }

    override fun onStop() {
        super.onStop()
        binding.textView.text = getString(R.string.onStop)
        print("OnStop()")
    }

    override fun onResume() {
        super.onResume()
        binding.textView.text = getString(R.string.onResume)
        print("OnResume()")
    }

    override fun onPause() {
        super.onPause()
        binding.textView.text = getString(R.string.onPause)
        print("OnPause()")
    }
    override fun onRestart() {
        super.onRestart()
        binding.textView.text = getString(R.string.onRestart)
        print("OnRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.textView.text = getString(R.string.onDestroy)
        print("OnDestroy()")
    }

    private fun print(msg: String) {
        Log.d("Activity state", msg)
    }

}