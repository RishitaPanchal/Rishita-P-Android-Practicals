package architecture.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMCardViewModel: ViewModel() {

    /** Instance variable */
    val etCardNumber = MutableLiveData<String>()
    val etCvv = MutableLiveData<String>()

    fun checkStatus(): String {
        val model = MVVMCardModel(etCardNumber.value.toString(), etCvv.value.toString())
        return when {
            model.emptyDetails() -> "Fields should not be empty!"
            model.validCardNumber() -> "Card number must contains 12 digits"
            model.validCVV() -> "CVV must be of 3 digits"
            else -> "Success"
        }
    }

}