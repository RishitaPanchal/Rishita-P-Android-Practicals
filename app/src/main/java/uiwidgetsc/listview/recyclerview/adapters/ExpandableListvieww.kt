package uiwidgetsc.listview.recyclerview.adapters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityExpandableListviewBinding

class ExpandableListvieww : AppCompatActivity() {

    private lateinit var listviewAdapter: ExpandableListViewAdapter
    private val movieData = mutableListOf<DataExpandableListView>()
    private lateinit var binding: ActivityExpandableListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_listview)
        binding = ActivityExpandableListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dClass = InitDataForExpandableRecyclerAndList(this)
        dClass.initDataExpandableListView(movieData)
        registerAdapter()
    }

    private fun registerAdapter() {
        listviewAdapter = ExpandableListViewAdapter(this, movieData)
        binding.expandableListview.setAdapter(listviewAdapter)
    }

}
