package dependancy.injection

import com.example.kotlin_java_practicalss.R

/** Data class */
class Student (
    val image: Int,
    val name: String,
    val course: String
)

/** Interface */
interface StudentRepository {
    fun getDetails(): List<Student>
}

/** Class implementing interface */
class StudentRepositoryData: StudentRepository {

   override fun getDetails() =  listOf(
       Student(R.drawable.lock,"Rishita Panchal", "Swift"),
       Student(R.drawable.lock,"Hely Pandya", "C++"),
       Student(R.drawable.lock,"Hiral Panchal", "C")
   )

}

