package uiwidgetsc.listview.recyclerview.adapters

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityListviewWithImageBinding

class ListviewWithImage : AppCompatActivity() {

    private lateinit var binding: ActivityListviewWithImageBinding
    private val settings = arrayOf("wifi", "Blutooth", "App", "Sounds", "Home screen", "Display", "Theme", "Accounts and sync", "Lock screen")
    private val images = arrayOf(
        R.drawable.wifi, R.drawable.settings, R.drawable.settings,
        R.drawable.sounds, R.drawable.home, R.drawable.display,
        R.drawable.theme, R.drawable.ic_profile, R.drawable.lock
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview_with_image)
        binding = ActivityListviewWithImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listAdapter = ListAdapter(this, settings, images)
        binding.listview.adapter = listAdapter

        binding.listview.setOnItemClickListener { adapterView, _, position, _ ->
            val item = adapterView.getItemAtPosition(position)
            Toast.makeText(this,"$item selected", Toast.LENGTH_LONG).show()
        }
    }

}