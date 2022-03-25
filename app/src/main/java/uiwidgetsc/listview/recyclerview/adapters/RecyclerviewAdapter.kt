package uiwidgetsc.listview.recyclerview.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import kotlinx.android.synthetic.main.simple_recyclerview_row.view.*

class RecyclerviewAdapter(val context: Context, private val items: Array<String>) :
    RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    var filteredData: Array<String>

    init {
       filteredData = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.simple_recyclerview_row,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredData[position]
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

  /*  override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): Filter.FilterResults {
                var listFilter: Array<String>
                if(p0==null||p0.isEmpty())
                {
                    listFilter = items
                }else
                {
                    val filterPattern: String = p0.toString().toLowerCase().trim()
                    for (item in items) {
                        if (item.toLowerCase().contains(filterPattern)) {
                            listFilter = items
                        }
                    }
                }
                val results = Filter.FilterResults()
                //results.values = listFilter
                return  results;
            }
            override fun publishResults(p0: CharSequence?, p1: Filter.FilterResults?) {
                //listdataSearch.clear()
                //listdataSearch.addAll(p1?.values as Collection<ExampleData>)
                notifyDataSetChanged()
            }
        }

    }*/

}

