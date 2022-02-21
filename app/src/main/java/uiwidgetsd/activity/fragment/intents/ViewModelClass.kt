package uiwidgetsd.activity.fragment.intents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass: ViewModel() {
    val message: MutableLiveData<String> = MutableLiveData("Type something")
    //val messageReadOnly: LiveData<String> = message

    fun setData(input: String) {
        message.value = input
    }

}