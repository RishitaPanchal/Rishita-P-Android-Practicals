package uiwidgetsc.listview.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import kotlinx.android.synthetic.main.fragment_one_viewpager2.view.*

class Viewpager2PageAdapter(val context: Context): RecyclerView.Adapter<Viewpager2PageAdapter.ViewHolder>() {

    var colorIconMatrix = arrayOf(
        intArrayOf(android.R.color.darker_gray, android.R.drawable.ic_dialog_email),
        intArrayOf(android.R.color.holo_green_dark, android.R.drawable.ic_menu_search)
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: LinearLayout = view.container
        val image: ImageView = view.imageView1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.fragment_one_viewpager2, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(colorIconMatrix[position][1])
        holder.container.setBackgroundResource(colorIconMatrix[position][0])
    }

    override fun getItemCount(): Int {
        return colorIconMatrix.size
    }

}