package uiwidgetsc.listview.recyclerview.adapters

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityBottomNavigationWithViewpagerBinding
import com.google.android.material.navigation.NavigationBarView


class BottomNavigationWithViewpager : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationWithViewpagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_with_viewpager)
        binding = ActivityBottomNavigationWithViewpagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavigation()
        setViewpagerAdapter()
    }

    private fun setBottomNavigation() {
        binding.bottomnavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.menu1 -> binding.viewPager.currentItem = 0
                R.id.menu2 -> binding.viewPager.currentItem = 1
                R.id.menu3 -> binding.viewPager.currentItem = 2
            }
            true
        })
    }

    private fun setViewpagerAdapter() {
        binding.viewPager.adapter = BottomNavigationPagerAdapter(supportFragmentManager)
    }

}