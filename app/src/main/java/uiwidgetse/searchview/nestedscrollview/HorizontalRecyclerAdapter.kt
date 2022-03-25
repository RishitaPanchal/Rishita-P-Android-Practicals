package uiwidgetse.searchview.nestedscrollview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import kotlinx.android.synthetic.main.horizontal_list_item.view.*
import java.util.*
import kotlin.collections.ArrayList


class HorizontalRecyclerAdapter(val context: Context, var items: ArrayList<ListDataClass>) :
    RecyclerView.Adapter<HorizontalRecyclerAdapter.ViewHolder>(), Filterable {

    var filterList = ArrayList<ListDataClass>()

    init {
        filterList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(context)
            .inflate(R.layout.horizontal_list_item, parent,false)
        )
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                filterList = if (charSearch.isEmpty()) {
                    items
                } else {
                    val resultList = ArrayList<ListDataClass>()
                    for (row in items) {
                        if (row.name?.lowercase(Locale.ROOT)
                                ?.contains(charSearch.lowercase(Locale.ROOT)) == true
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
                filterList = results?.values as ArrayList<ListDataClass>
                notifyDataSetChanged()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filterList[position]
        holder.tvItem.text = item.name
        item.image?.let { holder.image.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.name
        val image: ImageView = view.image
    }

}
