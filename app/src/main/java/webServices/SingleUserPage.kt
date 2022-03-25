package webServices

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivitySingleUserPageBinding
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_alert.view.*
import kotlinx.android.synthetic.main.custom_alert.view.email
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class SingleUserPage : AppCompatActivity(), View.OnClickListener {

    /** Instance variable */
    private lateinit var binding: ActivitySingleUserPageBinding
    private lateinit var bundle: Bundle
    private var id: Int = 0

    /** Overridden method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_user_page)
        binding = ActivitySingleUserPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bundle = intent.extras!!
        id = bundle.get("idUser") as Int
        binding.click = this

        Thread {
            try {
                get(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    /** Functions */
    fun get(id: Int) {
        val url = URL("https://reqres.in/api/users/$id")
        val connection = url.openConnection() as HttpURLConnection
        Log.e("url","$url")
        with(connection) {
            requestMethod = "GET"
            BufferedReader(InputStreamReader(inputStream)).use { inp ->
                val response = inp.readText()
                Log.e("Response Data", response)
                val gson = Gson()
                val data = gson.fromJson(response, SingleUserData::class.java)
                Log.e("Response Data", data.toString())
                runOnUiThread {
                    val fullName = "Name : ${data.userList.firstName.toString()} ${data.userList.lastName.toString()}"
                    val email = "Email : ${data.userList.email.toString()}"
                    binding.name.text = fullName
                    Picasso.get().load(data.userList.avatar).into(binding.image)
                    binding.email.text = email
                }
            }
        }
    }

    private fun showDialogue(context: Context) {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_alert,null)
        dialogBuilder.setView(dialogView)
        dialogView.email.setHint("Email")
        dialogView.login.setOnClickListener {
            if(dialogView.email.text.isEmpty() || dialogView.password.text.isEmpty()) {
                Toast.makeText(this,"Field should not be empty!!", Toast.LENGTH_SHORT).show()
            } else {
                postData(dialogView.email.text.toString(), dialogView.password.text.toString())
            }
        }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    private fun postData(name: String, job: String) {
        val retrofitData = APIClient.retrofitBuilder.postData(
            PostData(job, name)
        )
        retrofitData.enqueue(object : Callback<PostResponseData> {
            override fun onResponse(call: Call<PostResponseData>, response: Response<PostResponseData>) {
                if(response.code() == 201) {
                    val responseStatus = response.body()
                    Toast.makeText(this@SingleUserPage, "Response code : ${response.code()}\n ID  : ${responseStatus?.id} \nName : ${responseStatus?.name}\n job : ${responseStatus?.job} \n createdAt : ${responseStatus?.createdAt}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SingleUserPage, "Failure!!", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<PostResponseData>, t: Throwable) {
                Toast.makeText(this@SingleUserPage, "Url mismatch!!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteDatta(id: Int) {
        val retrofitData = APIClient.retrofitBuilder.deleteData(id)
        retrofitData.enqueue(object: Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.code() ==  204) {
                    Toast.makeText(this@SingleUserPage,
                        "Deleted successfully!! \nResponse code: ${response.code()}",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SingleUserPage,
                        "Failed to delete data of selected id : $id!",
                        Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(this@SingleUserPage,"URL mistmatch!!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateDataByPut(id: Int) {
        val retrofitData = APIClient.retrofitBuilder.putData(id, PostData("Job", "Name"))
        retrofitData.enqueue(object: Callback<PostData>{
            override fun onResponse(call: Call<PostData>, response: Response<PostData>) {
                if (response.code() == 200) {
                    Toast.makeText(this@SingleUserPage, "Data updated using put!! \nResponse code : ${response.code()}", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this@SingleUserPage, "Failed to delete data of id: $id", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            override fun onFailure(call: Call<PostData>, t: Throwable) {
                Toast.makeText(this@SingleUserPage,"Url Mismatch", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateDataByPatch(id: Int) {
        val retrofitData = APIClient.retrofitBuilder.patchData(id, PostData("abc", "Name"))
        retrofitData.enqueue(object: Callback<PostData>{
            override fun onResponse(call: Call<PostData>, response: Response<PostData>) {
                if (response.code() == 200) {
                    Toast.makeText(this@SingleUserPage, "Data updated using patch!! \nResponse code : ${response.code()}", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this@SingleUserPage, "Failed to delete data of id: $id", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            override fun onFailure(call: Call<PostData>, t: Throwable) {
                Toast.makeText(this@SingleUserPage,"Url Mismatch", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.addUser.id -> showDialogue(this)
            binding.delete.id -> deleteDatta(id)
            binding.put.id ->  updateDataByPut(id)
            binding.patch.id -> updateDataByPatch(id)
        }
    }

}