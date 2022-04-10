package architecture.mvvm

import android.text.TextUtils

class MVVMCardModel(val cardNumber: String, val cvv: String) {

    fun validation(): Int {
        return if(TextUtils.isEmpty(cardNumber) || TextUtils.isEmpty(cvv)) {
            0
        } else if(cardNumber.length < 12) {
            1
        } else if(cvv.length > 3 || cvv.length < 3) {
            2
        } else {
            -1
        }
    }

}