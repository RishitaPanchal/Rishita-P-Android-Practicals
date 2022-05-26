package dependancy.injection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/** ViewModel */
@HiltViewModel
class DIStudentViewModel @Inject constructor(private val studentRepo: StudentRepository): ViewModel() {

    private val _studentCourse = MutableLiveData<List<Student>>()
    val studentCourse: LiveData<List<Student>>
     get() = _studentCourse

    init {
        loadStudentData()
    }

    private fun loadStudentData() {
        _studentCourse.value = studentRepo.getDetails()
    }

}