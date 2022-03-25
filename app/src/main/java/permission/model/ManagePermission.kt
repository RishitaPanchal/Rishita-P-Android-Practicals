package permission.model

import android.app.Activity
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import com.example.kotlin_java_practicalss.R

class ManagePermission(val activity: Activity, val list: List<String>, val code:Int) {

    fun checkPermissions() {
        if (isPermissionsGranted() != PackageManager.PERMISSION_GRANTED) requestPermissions() else  Toast.makeText(activity, R.string.permission_already_granted, Toast.LENGTH_SHORT).show()
    }

    private fun isPermissionsGranted(): Int {
        var counter = 0
        for (permission in list) {
            counter += ContextCompat.checkSelfPermission(activity, permission)
        }
        return counter
    }

    private fun deniedPermission(): String {
        for (permission in list) {
            if (ContextCompat.checkSelfPermission(activity, permission)
                == PackageManager.PERMISSION_DENIED) return permission
            Log.d("permission", permission)
        }
        return ""
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(R.string.dialogue_title_multiple_permission)
        builder.setMessage(R.string.dialogue_message_multiple_permission)
        builder.setNeutralButton(R.string.ok, null)
        val dialog = builder.create()
        dialog.show()
    }

    private fun requestPermissions() {
        val permission = deniedPermission()
        if (shouldShowRequestPermissionRationale(activity, permission)) showAlert() else ActivityCompat.requestPermissions(activity, list.toTypedArray(), code)
    }

}