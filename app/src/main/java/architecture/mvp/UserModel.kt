package architecture.mvp

import android.text.TextUtils


class UserModel(email: String, password: String): IUserModel {

    private var cardNumber: String = ""
    var cvv: String = ""

    init {
        cardNumber = email
        cvv = password
    }

    override fun getCardNumber(): String {
        return cardNumber
    }

    override fun getCVV(): String {
        return cvv
    }

    override fun validation(): Int {
        return if(TextUtils.isEmpty(getCardNumber()) || TextUtils.isEmpty(getCVV())) {
            0
        } else if(getCardNumber().length < 12) {
            1
        } else if(getCVV().length > 3 || getCVV().length < 3) {
            2
        } else {
            -1
        }
    }

}