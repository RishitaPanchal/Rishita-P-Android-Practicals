package permission.model

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlin_java_practicalss.databinding.ActivityRuntimePermissionModelBinding

class RuntimePermissionModel : AppCompatActivity(), View.OnClickListener {

    private val locationReqCode = 101
    private val cameraCode = 201

    private lateinit var binding: ActivityRuntimePermissionModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRuntimePermissionModelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
    }

   private fun checkForPermission(permission: String, name: String, requestCode: Int) {
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
           when {
               ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_GRANTED -> {
                   Toast.makeText(this,"Permission granted", Toast.LENGTH_SHORT).show()
               }
               shouldShowRequestPermissionRationale(permission) -> displayDialogue(permission, name, requestCode)
               else -> ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode )
           }
       }
   }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fun innerCheck(name: String) {
            if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Permission for $name denied", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Permission $name Granted", Toast.LENGTH_SHORT).show()
            }
        }
        when (requestCode) {
            locationReqCode -> innerCheck("Location")
            cameraCode -> innerCheck("camera")
        }
    }

    private fun displayDialogue(permission: String, name: String, requestCode: Int) {
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

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnLocation.id -> checkForPermission(Manifest.permission.ACCESS_COARSE_LOCATION, "Location", locationReqCode)
            binding.btnCamera.id -> checkForPermission(Manifest.permission.CAMERA, "Camera", cameraCode)
        }
    }

}