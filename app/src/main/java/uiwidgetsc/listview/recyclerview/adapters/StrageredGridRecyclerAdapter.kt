package uiwidgetsc.listview.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import kotlinx.android.synthetic.main.stragered_grid_recycler_layout.view.*

class StrageredGridRecyclerAdapter(val context: Context, private val img: Array<Int>) :
    RecyclerView.Adapter<StrageredGridRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.stragered_grid_recycler_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageRes = img[position]
        holder.image.setImageResource(imageRes)
    }

    override fun getItemCount(): Int {
        return img.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.imgview
    }

}