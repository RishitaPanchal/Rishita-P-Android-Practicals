package architecture.mvp

class CardController(private val cardView: ICardView) : ICardController {

    override fun onSubmit(cardNumber: String, cvv: String) {

        val userModel = UserModel(cardNumber, cvv)

        when (userModel.validation()) {
            "EmptyFields" -> cardView.failure("Fields should not be empty!!")
            "InvalidCardNumber" -> cardView.failure("Card number must contains 12 digits!!")
            "InValidCVV" ->  cardView.failure("CVV must be of 3 digits")
            else -> cardView.success("Successfully added!")
        }

    }

}