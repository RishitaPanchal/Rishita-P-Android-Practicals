package uiwidgetsd.activity.fragment.intents

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_java_practicalss.R

class FragmentA : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("status","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("status", "onstart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("status", "onresume")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("status", "onAttatch")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("status","onDestroyview")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("status", "OnDetatch")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

}