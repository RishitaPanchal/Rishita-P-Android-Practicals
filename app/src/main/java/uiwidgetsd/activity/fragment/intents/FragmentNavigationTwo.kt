package uiwidgetsd.activity.fragment.intents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.FragmentNavigationTwoBinding

class FragmentNavigationTwo : Fragment() {

    private lateinit var binding: FragmentNavigationTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNavigationTwoBinding.inflate(layoutInflater)
        return binding.root

    }

}