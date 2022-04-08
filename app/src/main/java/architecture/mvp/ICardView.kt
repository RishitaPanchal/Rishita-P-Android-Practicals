package architecture.mvp

interface ICardView {
    fun success(message: String)
    fun failure(message: String)
}