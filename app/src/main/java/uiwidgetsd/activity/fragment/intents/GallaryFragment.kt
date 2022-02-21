package uiwidgetsd.activity.fragment.intents

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.FragmentGallaryBinding
import java.lang.Exception
import java.util.*

class GallaryFragment : Fragment() {

    private lateinit var _binding: FragmentGallaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGallaryBinding.inflate(inflater, container, false)

        val getAction = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback { uri ->
                _binding.imageView.setImageURI(uri)
            }
        )
        _binding.floatingActionButton.setOnClickListener {
            getAction.launch("image/*")
            _binding.header.text = ""
            Toast.makeText(context, "Hey from gallary", Toast.LENGTH_SHORT).show()
        }
        _binding.floatingActionButton2.setOnClickListener {
            val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePicture, 42)
            } catch (E: Exception) {
                Log.d("msg", "Unable to open a camera")
            }
            Toast.makeText(context, "Hey from camera", Toast.LENGTH_SHORT).show()
        }
        return _binding.root

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 42 && resultCode == Activity.RESULT_OK) {
            val takenImage = data?.extras?.get("data") as Bitmap
            _binding.imageView.setImageBitmap(takenImage)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}
