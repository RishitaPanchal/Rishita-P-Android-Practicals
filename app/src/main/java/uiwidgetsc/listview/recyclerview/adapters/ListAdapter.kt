package uiwidgetsc.listview.recyclerview.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlin_java_practicalss.R

class ListAdapter(private val context: Activity, private val settingName: Array<String>, private val imgid: Array<Int>) :
    ArrayAdapter<String>(context, R.layout.listview_components, settingName) {

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.listview_components, null, true)
        val uname = rowView.findViewById(R.id.name) as TextView
        val image = rowView.findViewById(R.id.dp) as ImageView
        uname.text = settingName[position]
        image.setImageResource(imgid[position])
        return rowView
    }

}