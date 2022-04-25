package uiwidgetsd.activity.fragment.intents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass: ViewModel() {
    val message: MutableLiveData<String> = MutableLiveData("Type something")

    fun setData(input: String) {
        message.value = input
    }

}