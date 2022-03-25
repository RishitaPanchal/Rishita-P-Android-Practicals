package uiwidgetse.searchview.nestedscrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivitySearchviewInHorizontalListBinding
import com.example.kotlin_java_practicalss.databinding.ActivitySearchviewInRecyclerviewBinding

class SearchviewInHorizontalList : AppCompatActivity() {

    /** Instance variable */
    var countryList = ArrayList<ListDataClass>()
    private lateinit var binding: ActivitySearchviewInHorizontalListBinding
    var adapter: HorizontalRecyclerAdapter = HorizontalRecyclerAdapter(this, countryList)

    /** Overrideen method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchview_in_horizontal_list)
        binding = ActivitySearchviewInHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecylcerview()
        performSearch()
    }

    /** Functions */
    private fun initRecylcerview() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        binding.verticalRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        countryList.add(ListDataClass(R.drawable.india, "India"))
        countryList.add(ListDataClass(R.drawable.australia, "Australia"))
        countryList.add(ListDataClass(R.drawable.usa, "USA"))
        countryList.add(ListDataClass(R.drawable.pakistan, "Pakistan"))
        countryList.add(ListDataClass(R.drawable.japan, "Japan"))
        countryList.add(ListDataClass(R.drawable.singapore, "Singapore"))

        val dividerItemDecoration =
            DividerItemDecoration(binding.recyclerview.context, LinearLayoutManager.HORIZONTAL)
        binding.recyclerview.addItemDecoration(dividerItemDecoration)
        binding.verticalRecyclerview.addItemDecoration(dividerItemDecoration)

        adapter = HorizontalRecyclerAdapter(this, countryList)
        binding.recyclerview.adapter = adapter
        binding.verticalRecyclerview.adapter =adapter
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