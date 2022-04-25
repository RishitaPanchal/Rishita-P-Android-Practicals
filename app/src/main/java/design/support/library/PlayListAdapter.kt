package design.support.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.RecentItemsBinding

class PlayListAdapter(private val items: ArrayList<PlayListDataClass>) :
    RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

    private lateinit var binding: RecentItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RecentItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.txtSong.text = item.name
        holder.binding.txtPlay.text = item.playName
        holder.binding.imgSong.setImageResource(item.image)
        holder.binding.imageButton.setOnClickListener {
            holder.binding.imageButton.setImageResource(R.drawable.search)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val binding: RecentItemsBinding) : RecyclerView.ViewHolder(binding.root) {}

}