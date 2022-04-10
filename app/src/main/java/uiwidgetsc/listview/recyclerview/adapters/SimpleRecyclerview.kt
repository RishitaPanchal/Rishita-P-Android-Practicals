package uiwidgetsc.listview.recyclerview.adapters

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivitySimpleRecyclerviewBinding

class SimpleRecyclerview : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivitySimpleRecyclerviewBinding
    lateinit var adapter: RecyclerviewAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_recyclerview)
        binding = ActivitySimpleRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        val settings = arrayOf(
            "wifi",
            "Blutooth",
            "App",
            "Sounds",
            "Home screen",
            "Display",
            "Theme",
            "Accounts and sync",
            "Lock screen"
        )

        val dividerItemDecoration =
            DividerItemDecoration(binding.recyclerview.context, LinearLayoutManager.VERTICAL)
        binding.recyclerview.addItemDecoration(dividerItemDecoration)

        val itemAdapter = RecyclerviewAdapter(this, settings)
        binding.recyclerview.adapter = itemAdapter
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

}