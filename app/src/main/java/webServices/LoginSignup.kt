package webServices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityLoginSignupBinding
import kotlinx.android.synthetic.main.activity_uiwidgets.*
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class LoginSignup : AppCompatActivity() {

    /** Instance variable */
    private lateinit var binding: ActivityLoginSignupBinding

    /** Overridden method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)
        binding = ActivityLoginSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = binding.email.text
        val password = binding.password.text
        binding.login.setOnClickListener {
            loadRecyclerView(username.toString(), password.toString())
        }
    }

    /** Functions */
    private fun loadRecyclerView(username: String, password: String) {
        Thread {
            try {
                val result = sendPostRequest(username, password)
                Log.d("status", "$result")
                runOnUiThread {
                    if(result) {
                        val intent = Intent(this, ListUsers::class.java);
                        startActivity(intent)
                        Toast.makeText(this, "Success!!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Failure!!", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun sendPostRequest(email: String, password: String) : Boolean {
        val credentials = JSONObject()
        credentials.put("email", email)
        credentials.put("password", password)
        var responseStatus = false
        val url = URL("https://reqres.in/api/login")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json")
            val wr = OutputStreamWriter(outputStream)
            wr.write(credentials.toString())
            wr.flush()
            Log.d("Response code: ", "$responseCode")
            responseStatus = responseCode == 200
        }
        return responseStatus
    }

}