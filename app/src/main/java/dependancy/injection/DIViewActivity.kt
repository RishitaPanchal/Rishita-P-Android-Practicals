package dependancy.injection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_java_practicalss.databinding.ActivityViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DIViewActivity : AppCompatActivity() {

    /** Instance variable */
    private val viewModel: DIStudentViewModel by viewModels()
    private lateinit var binding: ActivityViewBinding

    /** Overridden Method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeStudentCourse()
    }

    /** Function */
    private fun observeStudentCourse() {
        viewModel.studentCourse.observe(this) {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = StudentRecyclerViewAdapter(it)
        }
    }

}