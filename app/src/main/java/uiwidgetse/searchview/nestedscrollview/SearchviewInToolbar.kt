package uiwidgetse.searchview.nestedscrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.SearchView
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivitySearchviewInToolbarBinding
import com.example.kotlin_java_practicalss.databinding.ActivitySimpleListViewBinding

class SearchviewInToolbar : AppCompatActivity() {

    /** Instance variable */
    var laptops = arrayListOf<String>()
    var adapter: ArrayAdapter<String>? = null
    private lateinit var binding: ActivitySearchviewInToolbarBinding

    /** Overriden methods */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchview_in_toolbar)
        binding = ActivitySearchviewInToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.searchview, menu)
        val search = menu?.findItem(R.id.action_search)
        if (search != null) {
            val searchview = search.actionView as androidx.appcompat.widget.SearchView

            searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (laptops.contains(query)) {
                        adapter?.filter?.filter(query)
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter?.filter?.filter(newText)
                    return true
                }
            })

        }
        return super.onCreateOptionsMenu(menu)
    }

    /** Function */
    private fun initListData() {
        laptops = arrayListOf("HP",
            "Dell",
            "Asus",
            "Macbook pro",
            "Sony",
            "Lenovo",
            "Toshiba",
            "Acer",
            "LG")
        adapter = ArrayAdapter(this, R.layout.simple_list_component, laptops)
        binding.listview1.adapter = adapter
    }

}