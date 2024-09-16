package webServices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityListUsersManualJsonParseBinding
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class ListUsersManualJsonParse : AppCompatActivity() {

    /** Instance variables */
    private val client = OkHttpClient()
    var usersDetails: ArrayList<Data> = ArrayList()
    private lateinit var binding: ActivityListUsersManualJsonParseBinding
    private lateinit var adapter: ApiItemsAdapterList

    /** Overidden method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users_manual_json_parse)
        binding = ActivityListUsersManualJsonParseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            run("https://reqres.in/api/users?page=2")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /** Function */
    private fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("tag","Failure")
            }
            override fun onResponse(call: Call, response: Response) {
                response.body()?.let {
                    val responseStatus = it.string()
                    val jsonContact= JSONObject(responseStatus)
                    val jsonarrayInfo: JSONArray= jsonContact.getJSONArray("data")
                    usersDetails = ArrayList()
                    for(i in 0 until jsonarrayInfo.length()) {
                        val jsonObjectDetails: JSONObject = jsonarrayInfo.getJSONObject(i)
                        val dataClass = Data()
                        dataClass.id = jsonObjectDetails.getInt("id")
                        dataClass.email = jsonObjectDetails.getString("email")
                        dataClass.firstName = jsonObjectDetails.getString("first_name")
                        dataClass.lastName = jsonObjectDetails.getString("last_name")
                        dataClass.avatar = jsonObjectDetails.getString("avatar")
                        usersDetails.add(dataClass)
                    }
                    runOnUiThread {
                        adapter = ApiItemsAdapterList(this@ListUsersManualJsonParse, usersDetails)
                        binding.listItems.adapter = adapter
                        binding.listItems.layoutManager = LinearLayoutManager(this@ListUsersManualJsonParse)
                    }
                }

            }
        })
    }

}