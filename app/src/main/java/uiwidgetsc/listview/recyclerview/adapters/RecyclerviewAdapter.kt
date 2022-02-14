package uiwidgetsc.listview.recyclerview.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import kotlinx.android.synthetic.main.simple_recyclerview_row.view.*

class RecyclerviewAdapter(val context: Context, private val items: Array<String>) :
    RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.simple_recyclerview_row,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvItem.text = item
        holder.image.setImageResource(R.drawable.lock)
        //When you click on the chekbox it will set unlock icon

        holder.checkbox.setOnClickListener {
            if(holder.checkbox.isChecked) {
                holder.image.setImageResource(R.drawable.unlock)
                holder.card.setBackgroundResource(R.color.white_gray)
            } else {
                holder.image.setImageResource(R.drawable.lock)
                holder.card.setBackgroundResource(R.color.white)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.item
        val checkbox: CheckBox = view.checkbox_row
        val image: ImageView = view.image
        val card: CardView = view.card_view_item
        val layout: LinearLayout = view.layout
    }

}
