package uiwidgetsc.listview.recyclerview.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityExpandableRecyclerviewBinding
import com.example.kotlin_java_practicalss.databinding.ActivityViewpagerDemoBinding
import kotlinx.android.synthetic.main.activity_viewpager_demo.*

class ViewpagerDemo : AppCompatActivity() {

    private lateinit var binding: ActivityViewpagerDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewpagerDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager.adapter = PageAdapter(supportFragmentManager)
        binding.tablayout.setupWithViewPager(viewpager)

    }

}