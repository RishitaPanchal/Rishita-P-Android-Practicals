package uiwidgetsc.listview.recyclerview.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityExpandableRecyclerviewBinding

class ExpandableRecyclerview : AppCompatActivity() {

    private val movieData = mutableListOf<DataClassExpandableRecyclerView>()
    private lateinit var binding: ActivityExpandableRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_recyclerview)
        binding = ActivityExpandableRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dClass = InitDataForExpandableRecyclerAndList(this)
        dClass.initDataExpandableRecyclerView(movieData)
        setRecyclerview()
    }

    private fun setRecyclerview() {
        val expandableRecyclerAdapter = ExpandableRecyclerviewAdapter(this, movieData)
        binding.expandableRecyclerVieww.adapter = expandableRecyclerAdapter
    }

}
