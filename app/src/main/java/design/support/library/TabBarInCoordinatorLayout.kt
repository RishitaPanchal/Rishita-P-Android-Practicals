package design.support.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityTabBarInCoordinatorLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_viewpager_demo.*
import uiwidgetsc.listview.recyclerview.adapters.PageAdapter

class TabBarInCoordinatorLayout : AppCompatActivity() {

    private lateinit var binding: ActivityTabBarInCoordinatorLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBarInCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.tabLayout.setupWithViewPager(viewpager)
        val tabs = arrayOf(getString(R.string.recent), getString(R.string.Favorites))

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = tabs[pos]
        }.attach()
    }

}