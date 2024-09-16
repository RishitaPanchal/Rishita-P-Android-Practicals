package uiwidgetsc.listview.recyclerview.adapters

import android.content.Context
import com.google.gson.Gson
import java.lang.Exception

//Initialization of expandable recycler and listview
class InitDataForExpandableRecyclerAndList(val context: Context) {

    private fun extractJsonData(): APIResponse {
        val gson = Gson()
        val str = context.assets.open("Data.json").bufferedReader().use { it.readText() }
        return gson.fromJson(str, APIResponse::class.java)
    }

    fun initDataExpandableRecyclerView(movieData: MutableList<DataClassExpandableRecyclerView>): MutableList<DataClassExpandableRecyclerView> {
        try {
            val data = extractJsonData()
            data.forEach() {
                movieData.add(
                    DataClassExpandableRecyclerView(it.name, it.realname, it.team, it.firstappearance, it.imageurl, it.createdby, it.publisher, it.bio)
                )
            }
        } catch (E: Exception) {
            E.printStackTrace()
        }
        return movieData
    }
    fun initDataExpandableListView(movieData: MutableList<DataExpandableListView>): MutableList<DataExpandableListView> {
        try {
            val data = extractJsonData()
            data.forEach {
                movieData.add(
                    DataExpandableListView(it.name, listOf(it.realname, it.team, it.firstappearance, it.imageurl, it.createdby, it.publisher, it.bio))
                )
            }
        } catch (E: Exception) {
            E.printStackTrace()
        }
        return movieData
    }

}
