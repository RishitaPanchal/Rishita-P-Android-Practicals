package architecture.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class VMFViewModelFactory(private val initialTotal: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(VMFViewModel::class.java)) {
            return VMFViewModel(initialTotal) as T
        }
        throw IllegalArgumentException("ViewModel class not found!!")
    }
}