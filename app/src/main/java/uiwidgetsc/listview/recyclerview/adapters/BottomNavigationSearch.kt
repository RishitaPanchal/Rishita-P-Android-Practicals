package uiwidgetsc.listview.recyclerview.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_java_practicalss.R

class BottomNavigationSearch : Fragment() {

    companion object {
        fun newInstance(): BottomNavigationSearch {
            return BottomNavigationSearch()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_navigation_search, container, false)
    }

}