package uiwidgetsc.listview.recyclerview.adapters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityStrageredGridviewRecyclerviewBinding


class StrageredGridviewRecyclerview : AppCompatActivity() {

    private lateinit var binding: ActivityStrageredGridviewRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stragered_gridview_recyclerview)
        binding = ActivityStrageredGridviewRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview1.layoutManager =
            StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

        val images = arrayOf(
            R.drawable.explore_10, R.drawable.post2, R.drawable.explore_10,
            R.drawable.post2, R.drawable.explore_10, R.drawable.post2,
            R.drawable.explore_10, R.drawable.post2, R.drawable.explore_10
        )


        binding.recyclerview1.addItemDecoration(ItemDecorationInRecyclerview(3,50))

        val itemAdapter = StrageredGridRecyclerAdapter(this, images)
        binding.recyclerview1.adapter = itemAdapter
    }

}