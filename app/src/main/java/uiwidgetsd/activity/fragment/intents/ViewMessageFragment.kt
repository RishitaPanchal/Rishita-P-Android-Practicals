package uiwidgetsd.activity.fragment.intents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.FragmentViewMessageBinding


class ViewMessageFragment : Fragment() {

    val viewModel: ViewModelClass by activityViewModels()
    private lateinit var binding: FragmentViewMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentViewMessageBinding.inflate(layoutInflater)
        binding.message = viewModel.message.value
        return binding.root
    }

}