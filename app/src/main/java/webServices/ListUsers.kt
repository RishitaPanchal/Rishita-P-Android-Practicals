package webServices

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityListUsersBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUsers : AppCompatActivity() {

    /** Instance variables */
    private lateinit var binding: ActivityListUsersBinding
    private lateinit var adapter: ApiItemsAdapter

    /** Overridden method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)
        binding = ActivityListUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResponse()
    }

    /** Function */
    private fun getResponse() {
        APIClient.retrofitBuilder.getData().enqueue(object : Callback<MainDataClass> {
            override fun onFailure(call: Call<MainDataClass>, t: Throwable) {
                Log.e(javaClass.simpleName, "error: ${t.printStackTrace()}")
            }

            override fun onResponse(
                call: Call<MainDataClass>,
                response: Response<MainDataClass>,
            ) {
                binding.progressbar.visibility = View.GONE
                response.body()?.let {
                    val responseBody = it
                    adapter = ApiItemsAdapter(this@ListUsers, responseBody.usersList) { position ->
                        val intent = Intent(this@ListUsers, SingleUserPage::class.java)
                        intent.putExtra("idUser", responseBody.usersList[position].id);
                        startActivity(intent)
                        Toast.makeText(this@ListUsers,
                            "You have clicked on ${responseBody.usersList[position].id}",
                            Toast.LENGTH_SHORT).show()
                    }
                    binding.listItems.adapter = adapter
                    binding.listItems.layoutManager = LinearLayoutManager( this@ListUsers)
                }
            }
        })
    }

}