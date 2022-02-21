package uiwidgetsd.activity.fragment.intents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.SealedClassDemo
import com.example.kotlin_java_practicalss.databinding.FragmentAddMessageBinding


class AddMessageFragment : Fragment() {


    val viewModel: ViewModelClass by activityViewModels()
    lateinit var binding: FragmentAddMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddMessageBinding.inflate(layoutInflater)
        binding.floatingActionButton.setOnClickListener {
            viewModel.setData(binding.messageEdittext.text.toString())
            Toast.makeText(
                context,
                getString(R.string.Toastmsg3),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.message = viewModel.message.value
        return binding.root
    }


}