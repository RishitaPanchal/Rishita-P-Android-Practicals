package architecture.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityMvvmcardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MVVMCardView : AppCompatActivity(), View.OnClickListener {

    /** Instance variable */
    private lateinit var binding: ActivityMvvmcardBinding
    private val model: MVVMCardViewModel by viewModels()

    /** Overridden methhods */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMvvmcardBinding>(this, R.layout.activity_mvvmcard).apply {
            this.lifecycleOwner = this@MVVMCardView
            this.viewModel = model
        }
        binding.click = this
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.add.id -> Toast.makeText(this, model.checkStatus(), Toast.LENGTH_SHORT).show()
        }
    }

}