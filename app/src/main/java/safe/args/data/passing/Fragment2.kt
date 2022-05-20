package safe.args.data.passing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.kotlin_java_practicalss.R

import com.example.kotlin_java_practicalss.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding
    private val args: Fragment2Args by navArgs<Fragment2Args>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.apply {
            val age = args.name.toString()
            binding.txtData.text = age
        }.root
    }

}