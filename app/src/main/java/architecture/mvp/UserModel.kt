package architecture.mvp

import android.text.TextUtils

enum class CustomError {
    EmptyFields,
    InvalidCardNumber,
    InValidCVV,
    Success
}

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

    override fun validation(): String{
        return if(TextUtils.isEmpty(getCardNumber()) || TextUtils.isEmpty(getCVV())) {
            CustomError.EmptyFields.name
        } else if(getCardNumber().length < 12) {
            CustomError.InvalidCardNumber.name
        } else if(getCVV().length > 3 || getCVV().length < 3) {
            CustomError.InValidCVV.name
        } else {
            CustomError.Success.name
        }
    }

}