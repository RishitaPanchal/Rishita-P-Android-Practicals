package dependancy.injection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_java_practicalss.databinding.StudentListItemsBinding

class StudentRecyclerViewAdapter(private val items: List<Student>) :
    RecyclerView.Adapter<StudentRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            StudentListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.txtStudentName.text = item.name
        holder.binding.txtStudentCourse.text = item.course
        holder.binding.imageStudent.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(var binding: StudentListItemsBinding) : RecyclerView.ViewHolder(binding.root)

}


