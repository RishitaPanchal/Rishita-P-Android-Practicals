package permission.model

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlin_java_practicalss.databinding.ActivityCameraStoragePermissionBinding

class CameraStoragePermission : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCameraStoragePermissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraStoragePermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
    }

    companion object {
        private const val PICK_IMAGE_FROM_GALLARY = 1001
        private const val TAKE_AN_IMAGE = 1002
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.chooseImage.id -> {
                checkForPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE, "STORAGE", PICK_IMAGE_FROM_GALLARY)
            }
            binding.btnTakeImage.id -> {
                checkForPermission(android.Manifest.permission.CAMERA, "Camera", TAKE_AN_IMAGE)
            }
        }
    }

    private fun checkForPermission(permission: String, name: String, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_GRANTED -> {
                    when(requestCode) {
                        PICK_IMAGE_FROM_GALLARY -> pickImageFromGallary()
                        TAKE_AN_IMAGE -> takeAnImageFromCamera()
                    }
                    Toast.makeText(this,"Permission granted", Toast.LENGTH_SHORT).show()
                }
                shouldShowRequestPermissionRationale(permission) -> displayDialogue(name)
                else -> ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode )
            }
        }
    }

    private val getAction = registerForActivityResult(
        ActivityResultContracts.GetContent(),
        ActivityResultCallback { uri ->
            binding.imageView3.setImageURI(uri)
        }
    )

    private val cameraActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val bitmap: Bitmap = result.data?.extras?.get("data") as Bitmap
        binding.imageView3.setImageBitmap(bitmap)
    }

    private fun pickImageFromGallary() {
        getAction.launch("image/*")
    }

    private fun takeAnImageFromCamera() {
        val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraActivity.launch(camera)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Permission for allowed", Toast.LENGTH_SHORT).show()
            when (requestCode) {
                PICK_IMAGE_FROM_GALLARY -> pickImageFromGallary()
                TAKE_AN_IMAGE -> takeAnImageFromCamera()
            }
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayDialogue(name: String) {
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage("Permission access your $name is required to use this app")
            setTitle("Permission required!!")
            setPositiveButton("Ok", DialogInterface.OnClickListener {
                    _, _ -> finish()
            })
        }
        val dialogue = builder.create()
        dialogue.show()
    }
}