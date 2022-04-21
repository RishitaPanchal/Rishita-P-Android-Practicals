package design.support.library

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityCoordinatorLayoutBinding
import com.google.android.material.snackbar.Snackbar


class CoordinatorLayout : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCoordinatorLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click =this
    }

    override fun onClick(p0: View?) {
       when(p0?.id) {
           binding.showSnackBar.id -> {
               Snackbar.make(binding.coordinatorLayout,
                   getString(R.string.snackbar_message), Snackbar.LENGTH_LONG)
                   .setAction(getString(R.string.close)) {
                   }.show()
           }
       }
    }

}