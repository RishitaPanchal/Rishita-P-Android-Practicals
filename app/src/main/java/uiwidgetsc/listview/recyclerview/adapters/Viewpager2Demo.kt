package uiwidgetsc.listview.recyclerview.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivitySimpleListViewBinding
import com.example.kotlin_java_practicalss.databinding.ActivityViewpager2DemoBinding
import com.example.kotlin_java_practicalss.databinding.ActivityViewpagerDemoBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

class Viewpager2Demo : AppCompatActivity() {

    private lateinit var binding: ActivityViewpager2DemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager2_demo)
        binding = ActivityViewpager2DemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
    }
    private fun setAdapter() {
        binding.viewpager2.adapter = Viewpager2PageAdapter(this)
        binding.viewpager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Snackbar.make(binding.parentView,"You have selected ${position+1}",Snackbar.LENGTH_SHORT).show()
            }
        })
    }

}