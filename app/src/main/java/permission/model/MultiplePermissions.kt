package permission.model

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin_java_practicalss.databinding.ActivityMultiplePermissionsBinding

class MultiplePermissions : AppCompatActivity(), View.OnClickListener {

    private val PERMISSION_REQUEST_CODE = 123
    private lateinit var managePermissions: ManagePermission
    private lateinit var binding: ActivityMultiplePermissionsBinding
    private lateinit var list: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiplePermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = listOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.CAMERA
                    )
        binding.click = this
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.askForPermission.id -> {
                managePermissions = ManagePermission(this, list, PERMISSION_REQUEST_CODE)
                managePermissions.checkPermissions()
            }
        }
    }

}