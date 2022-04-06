package uiwidgetse.searchview.nestedscrollview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import kotlinx.android.synthetic.main.simple_recyclerview_row.view.*
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class AdapterRecyclerview(val context: Context, private var items: ArrayList<String>) :
    RecyclerView.Adapter<AdapterRecyclerview.ViewHolder>(), Filterable {

    var filterList = ArrayList<String>()

    init {
        filterList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(context)
            .inflate(R.layout.simple_recyclerview_row,parent,false)
        )
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                filterList = if (charSearch.isEmpty()) {
                    items
                } else {
                    val resultList = ArrayList<String>()
                    for (row in items) {
                        if (row.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filterList[position]
        holder.tvItem.text = item
        holder.image.setImageResource(R.drawable.lock)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.item
        val image: ImageView = view.image
        val layout: LinearLayout = view.layout
    }

}

