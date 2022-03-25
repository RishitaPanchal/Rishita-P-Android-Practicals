package architecture.mvvm

import android.text.TextUtils

class MVVMCardModel(private val cardNumber: String, val cvv: String) {

    /** Functions */
    fun emptyDetails(): Boolean {
        return ((TextUtils.isEmpty(cardNumber) || TextUtils.isEmpty(cvv)))
    }
    fun validCardNumber(): Boolean {
        return cardNumber.length < 12
    }
    fun validCVV(): Boolean {
        return cvv.length != 3
    }

}