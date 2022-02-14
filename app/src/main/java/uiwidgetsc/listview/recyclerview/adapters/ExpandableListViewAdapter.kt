
package uiwidgetsc.listview.recyclerview.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.kotlin_java_practicalss.R
import kotlinx.android.synthetic.main.expandable_listview_movie_details.view.*
import kotlinx.android.synthetic.main.expandable_listview_movies.view.*

class ExpandableListViewAdapter(
    val context: Context, private val movieData: List<DataExpandableListView>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return movieData.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return movieData[p0].moviDetail.size
    }

    override fun getGroup(p0: Int): Any {
        return movieData[p0].moviename
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return movieData[p0].moviDetail[p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    @SuppressLint("InflateParams")
    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val movieList = getGroup(p0)
        val view = LayoutInflater.from(context).inflate(R.layout.expandable_listview_movies, null)
        view.moviename.text = movieList.toString()
        return view
    }

    @SuppressLint("InflateParams")
    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        val movieDetailsList = getChild(p0, p1) as String
        val view = LayoutInflater.from(context).inflate(R.layout.expandable_listview_movie_details, null)
        view.moviedetails.text = movieDetailsList
        return view
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}
