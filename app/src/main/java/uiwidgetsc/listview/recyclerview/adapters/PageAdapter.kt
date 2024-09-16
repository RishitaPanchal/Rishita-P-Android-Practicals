package uiwidgetsc.listview.recyclerview.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
       when(position) {
           0 -> return RecentFragment()
           1 -> return  MyFavoritesFragment()
           else -> return RecentFragment()
       }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> return "Recent"
            1 -> return  "My favorites"
        }
        return super.getPageTitle(position)
    }

}