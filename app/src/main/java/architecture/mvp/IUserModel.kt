package architecture.mvp

interface IUserModel {
    fun getCardNumber() : String
    fun getCVV() : String
    fun validation(): String
}