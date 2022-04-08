package architecture.mvp

class CardController(private val cardView: ICardView) : ICardController {

    override fun onSubmit(cardNumber: String, cvv: String) {

        val userModel = UserModel(cardNumber, cvv)

        when (userModel.validation()) {
            0 -> {
                cardView.failure("Fields should not be empty!!")
            }
            1 -> {
                cardView.failure("Card number must contains 12 digits!!")
            }
            2 -> {
                cardView.failure("CVV must be of 3 digits")
            }
            else -> {
                cardView.success("Succesfully added!")
            }
        }
    }

}