package uiwidgetsd.activity.fragment.intents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityFragmentContainerViewDemoBinding
import com.example.kotlin_java_practicalss.databinding.FragmentGallaryBinding
import com.example.kotlin_java_practicalss.databinding.FragmentNavigationOneBinding

class FragmentNavigationOne : Fragment() {

    private lateinit var _binding: FragmentNavigationOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationOneBinding.inflate(layoutInflater)
        return _binding.root
    }

}