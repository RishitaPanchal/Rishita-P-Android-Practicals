package webServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/** Retrofit Interface */
interface RetrofitInterface {

    @GET("/api/users?delay=3")
    fun getData(): Call<MainDataClass>

    @POST("api/users")
    fun postData(@Body postData: PostData): Call<PostResponseData>

    @DELETE("api/users/{id}")
    fun deleteData(@Path("id") id:Int): Call<Unit>

    @PUT("/api/users/{id}")
    fun putData(@Path("id") id:Int, @Body postData: PostData): Call<PostData>

    @PATCH("/api/users/{id}")
    fun patchData(@Path("id") id: Int, @Body postData: PostData): Call<PostData>

    companion object {
        const val BASE_URL = "https://reqres.in/"
    }

}

/** Singleton object */
class APIClient {

    companion object {
        val retrofitBuilder: RetrofitInterface by lazy {
            val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor())
            return@lazy Retrofit.Builder().baseUrl(RetrofitInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
                .create(RetrofitInterface::class.java)
        }
    }

}