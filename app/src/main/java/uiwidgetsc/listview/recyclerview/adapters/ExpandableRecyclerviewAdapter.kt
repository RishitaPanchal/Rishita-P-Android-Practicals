package uiwidgetsc.listview.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import kotlinx.android.synthetic.main.expandable_recyclerview_rowview.view.*

class ExpandableRecyclerviewAdapter(val context: Context, private val movieData: List<DataClassExpandableRecyclerView>) :
    RecyclerView.Adapter<ExpandableRecyclerviewAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.expandable_recyclerview_rowview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val linearlayoutGroup: RelativeLayout = view.linearlayout
        val movieName1: TextView = view.grouptext
        val realName1: TextView = view.realname
        val team1:TextView = view.team
        val appearance1:TextView = view.Appearance
        val imgUrl1: TextView = view.imgurl
        val createdBy1: TextView = view.createby
        val publisher1:TextView = view.publisher
        val bio1:TextView = view.bio
        val expandableLayout: RelativeLayout = view.expandable_layout
        val iconDown: ImageView = view.icondown
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos: DataClassExpandableRecyclerView = movieData[position]
        holder.movieName1.text = pos.name
        holder.realName1.text = pos.realname
        holder.team1.text = pos.team
        holder.appearance1.text = pos.firstappearance
        holder.imgUrl1.text = pos.imageurl
        holder.createdBy1.text = pos.createdby
        holder.publisher1.text = pos.publisher
        holder.bio1.text = pos.bio
        val isExpandable: Boolean = movieData[position].expandable
        holder.expandableLayout.visibility = if(isExpandable) View.VISIBLE else View.GONE

        if(isExpandable) holder.iconDown.setImageResource(R.drawable.up) else holder.iconDown.setImageResource(R.drawable.down)

        holder.linearlayoutGroup.setOnClickListener {
            val expandData = movieData[position]
            expandData.expandable = !expandData.expandable
            notifyItemChanged(position)
        }
    }

}