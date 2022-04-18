package architecture.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityMvvmcardBinding

class MVVMCardView : AppCompatActivity(), View.OnClickListener {

    /** Instance variable */
    private lateinit var binding: ActivityMvvmcardBinding
    private lateinit var model: MVVMCardViewModel

    /** Overridden methhods */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this)[MVVMCardViewModel::class.java]
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