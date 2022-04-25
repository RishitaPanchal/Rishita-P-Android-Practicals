package uiwidgetsc.listview.recyclerview.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.FragmentRecentBinding
import design.support.library.PlayListAdapter
import design.support.library.PlayListDataClass

class RecentFragment : Fragment() {

    private lateinit var binding: FragmentRecentBinding
    lateinit var adapter: PlayListAdapter
    lateinit var songData: ArrayList<PlayListDataClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecentBinding.inflate(layoutInflater)
        val dividerItemDecoration =
            DividerItemDecoration(binding.recyclerview.context, LinearLayoutManager.VERTICAL)
        binding.recyclerview.addItemDecoration(dividerItemDecoration)
        songData = arrayListOf(
            PlayListDataClass("What makes you beautiful", R.drawable.whatmakes_u_beautiful, "OneDirection"),
            PlayListDataClass("Perfect", R.drawable.whatmakes_u_beautiful, "Ed-Sheran"),
            PlayListDataClass("A Thousand years", R.drawable.whatmakes_u_beautiful, "Ed-Sheran"),
            PlayListDataClass("Closer", R.drawable.whatmakes_u_beautiful, "Justin Biber"),
            PlayListDataClass("What makes you beautiful", R.drawable.whatmakes_u_beautiful, "OneDirection"),
            PlayListDataClass("What makes you beautiful", R.drawable.whatmakes_u_beautiful, "OneDirection"),
            PlayListDataClass("What makes you beautiful", R.drawable.whatmakes_u_beautiful, "OneDirection")
        )

        val itemAdapter = PlayListAdapter(songData)
        binding.recyclerview.layoutManager = LinearLayoutManager(activity)
        binding.recyclerview.adapter = itemAdapter
        return binding.root
    }

}