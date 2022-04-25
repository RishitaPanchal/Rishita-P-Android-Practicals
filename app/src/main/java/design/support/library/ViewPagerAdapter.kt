package design.support.library

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_java_practicalss.R
import uiwidgetsc.listview.recyclerview.adapters.MyFavoritesFragment
import uiwidgetsc.listview.recyclerview.adapters.RecentFragment

class ViewPagerAdapter(fragment: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragment, lifecycle) {

    private val tabs = arrayOf(R.string.recent, R.string.Favorites)

    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RecentFragment()
            1 -> MyFavoritesFragment()
            else -> MyFavoritesFragment()
        }
    }

}