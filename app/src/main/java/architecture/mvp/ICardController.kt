package architecture.mvp

interface ICardController {
    fun onSubmit(cardNumber: String, cvv: String)
}