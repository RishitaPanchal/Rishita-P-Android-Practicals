package safe.args.data.passing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = Fragment1Binding.inflate(layoutInflater)

        binding.btnSend.setOnClickListener {
            val action: NavDirections = Fragment1Directions.actionFragment1ToFragment2("Rishita")
            findNavController().navigate(action)
        }
        return binding.root
    }

}