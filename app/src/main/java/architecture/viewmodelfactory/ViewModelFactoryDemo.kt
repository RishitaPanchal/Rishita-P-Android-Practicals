package architecture.viewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityViewModelFactoryDemoBinding

class ViewModelFactoryDemo : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelFactoryDemoBinding
    private lateinit var viewModel: VMFViewModel
    private lateinit var viewModelFactory: VMFViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model_factory_demo)
        viewModelFactory = VMFViewModelFactory(100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(VMFViewModel::class.java)
        binding.tvResult.text = viewModel.getResult().toString()

        binding.btnAdd.setOnClickListener {
            viewModel.add(binding.etNumber.text.toString().toInt())
            binding.tvResult.text = viewModel.getResult().toString()
        }
    }

}