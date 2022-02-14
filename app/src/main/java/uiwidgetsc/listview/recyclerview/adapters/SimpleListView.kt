package uiwidgetsc.listview.recyclerview.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityListviewWithImageBinding
import com.example.kotlin_java_practicalss.databinding.ActivitySimpleListViewBinding

class SimpleListView : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view)

        binding = ActivitySimpleListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val laptops = arrayOf("HP", "Dell", "Asus", "Macbook pro", "Sony", "Lenovo", "Toshiba", "Acer", "LG")
        val adapter = ArrayAdapter(this, R.layout.simple_list_component, laptops)

        binding.listview1.adapter = adapter

    }

}