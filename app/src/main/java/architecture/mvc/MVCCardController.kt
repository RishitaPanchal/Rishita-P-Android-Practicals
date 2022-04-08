package architecture.mvc

class MVCCardController(val model: MVCCardModel, val view: MVCCardView) {

    private fun getCardNumber(): String {
        return model.cardNumber
    }

    private fun getCvv(): String {
        return  model.cvv
    }

    fun setCardNumber(cardNumber: String) {
        model.cardNumber = cardNumber
    }

    fun setCvv(cvv: String) {
        model.cvv = cvv
    }

    fun validateCardDetails() : String{
        val cardNumber = getCardNumber()
        val cvv = getCvv()
        return if(cardNumber == "" || cvv == "") {
            "Empty fields"
        } else if (cardNumber.length < 12){
            "Invalid card number"
        } else if (cvv.length < 3 || cvv.length > 3) {
            "Invalid CVV"
        } else {
            "Suscess"
        }
    }

}