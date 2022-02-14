package com.example.uiwidgets.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlin_java_practicalss.R
import com.example.uiwidgets.FragmentUiA
import com.example.uiwidgets.FragmentUiB
import com.example.uiwidgets.FragmentUiC


private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

class SectionsPagerAdapter(
    private val context: Context,
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val f: Fragment? = null
        when (position) {
            0 -> return FragmentUiA()
            1 -> return FragmentUiB()
            2 -> return FragmentUiC()
           // 3 -> return FragmentUiD()
            else -> return f!!
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 4
    }

}