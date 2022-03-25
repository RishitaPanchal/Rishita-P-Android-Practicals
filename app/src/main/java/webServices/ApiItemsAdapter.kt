package webServices

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_view_items_retrofit.view.*

/** Adapter recyclerview */
class ApiItemsAdapter(val context: Context, private val userData: List<Data>) :
    RecyclerView.Adapter<ApiItemsAdapter.ViewHolder>() {

    /** Instance variable */
    private lateinit var mListener: OnItemClickListener

    /** Interface */
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    /** Function */
    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    /** Adapter overridden methods*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(context)
            .inflate(R.layout.recycler_view_items_retrofit, parent,false), mListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = userData[position]
            val fullName = "${item.firstName} ${item.lastName}"
            holder.title.text = item.email
            holder.subtitle.text = fullName
            Picasso.get().load(item.avatar).into(holder.image)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    /** Class to set Views */
    class ViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.title
        val subtitle: TextView = view.subtitle
        val image: ImageView = view.image
        val layout: LinearLayout = view.layout
        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

 }
