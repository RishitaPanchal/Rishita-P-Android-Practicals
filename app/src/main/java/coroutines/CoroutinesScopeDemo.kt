package coroutines

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityCoroutinScopeBinding
import webServices.ApiItemsAdapterList
import webServices.Data

class CoroutinesScopeDemo: AppCompatActivity(){

    /** Instance variables */
    private lateinit var binding: ActivityCoroutinScopeBinding
    private lateinit var adapter: ApiItemsAdapterList
    private lateinit var viewModel: CoroutinesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinScopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CoroutinesViewModel::class.java]
        viewModel.users.observe(this) {
            binding.progressbar.visibility = View.GONE
            adapter = ApiItemsAdapterList(this, it as ArrayList<Data>)
            binding.listItems.adapter = adapter
            binding.listItems.layoutManager = LinearLayoutManager(this)
        }
    }

}