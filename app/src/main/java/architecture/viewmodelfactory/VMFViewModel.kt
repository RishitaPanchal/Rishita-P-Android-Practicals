package architecture.viewmodelfactory

import androidx.lifecycle.ViewModel

class VMFViewModel(initialTotal: Int): ViewModel() {

    private var result = 0

    init {
        result = initialTotal
    }

    fun add(text: Int) {
        result += text
    }

    fun getResult(): Int {
        return result
    }

}