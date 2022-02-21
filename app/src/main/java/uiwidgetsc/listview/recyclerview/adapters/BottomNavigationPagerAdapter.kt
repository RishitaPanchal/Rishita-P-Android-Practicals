package uiwidgetsc.listview.recyclerview.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class BottomNavigationPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
       return when(position) {
           0 -> BottomnavigationHome.newInstance()
           1 -> BottomNavigationSearch.newInstance()
           2 -> BottomNavigationMyprofile.newInstance()
           else -> BottomnavigationHome.newInstance()

       }
    }

}