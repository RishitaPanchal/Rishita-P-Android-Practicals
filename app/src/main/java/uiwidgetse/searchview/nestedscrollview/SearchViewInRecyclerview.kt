package uiwidgetse.searchview.nestedscrollview

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivitySearchviewInRecyclerviewBinding
import java.lang.StringBuilder

class SearchviewInRecyclerview : AppCompatActivity() {

    /** Instance variable */
    var items = ArrayList<String>()
    private lateinit var binding: ActivitySearchviewInRecyclerviewBinding
    var adapter: AdapterRecyclerview = AdapterRecyclerview(this, items)

    /** Overriden method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchview_in_recyclerview)
        binding = ActivitySearchviewInRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecylcerview()
        performSearch()
    }

    /** Functions */
    private fun initRecylcerview() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        items = arrayListOf(
            "India",
            "Pakistan",
            "Afganistan",
            "Japan",
            "Maldives",
            "Iceland",
            "Dubai",
            "Singapore",
            "Australia",
            "USA", "India",
            "Pakistan",
            "Afganistan",
            "Japan",
            "Maldives",
            "Iceland",
            "Dubai",
            "Singapore",
            "Australia",
            "USA"
        )
        val dividerItemDecoration =
        DividerItemDecoration(binding.recyclerview.context, LinearLayoutManager.VERTICAL)
        binding.recyclerview.addItemDecoration(dividerItemDecoration)
        adapter = AdapterRecyclerview(this, items)
        binding.recyclerview.adapter = adapter

        // To stop scrolling of recylerview
        /* binding.recyclerview.layoutManager = object : LinearLayoutManager(applicationContext) {
            override fun canScrollVertically(): Boolean = false
        } */
    }

    private fun performSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }

}

