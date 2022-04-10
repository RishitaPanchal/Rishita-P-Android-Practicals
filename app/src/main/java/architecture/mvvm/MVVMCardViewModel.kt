package architecture.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMCardViewModel: ViewModel() {

    val etCardNumber = MutableLiveData<String>()
    val etCvv = MutableLiveData<String>()

    fun checkStatus(): String {
        val model = MVVMCardModel(etCardNumber.value.toString(), etCvv.value.toString())
        return when (model.validation()) {
            0 -> {
                "Fields should not be empty!!"
            }
            1 -> {
                "Card number must contains 12 digits!!"
            }
            2 -> {
                "CVV must be of 3 digits"
            }
            else -> {
                "Succesfully added!"
            }
        }
    }

}