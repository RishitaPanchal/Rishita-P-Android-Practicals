package design.support.library

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uiwidgetsc.listview.recyclerview.adapters.MyFavoritesFragment

class MyPagerAdapter(fragment: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragment, lifecycle) {

    private val tabs = arrayOf("CHATS", "GROUPS", "STATUS", "CALLS")

    override fun getItemCount(): Int {
        return tabs.count()
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            1 -> MyFavoritesFragment()
            2 -> MyFavoritesFragment()
            3 -> MyFavoritesFragment()
            4 -> MyFavoritesFragment()
            else -> MyFavoritesFragment()
        }
    }

}

