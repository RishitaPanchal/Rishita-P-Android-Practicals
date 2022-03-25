package coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import webServices.APIClient
import webServices.Data

class CoroutinesViewModel: ViewModel() {
    private val mUsers: MutableLiveData<ArrayList<Data>> = MutableLiveData()
    val users: LiveData<ArrayList<Data>>
        get() =  mUsers

    init {
        viewModelScope.launch {
            mUsers.value = getResponse()
        }
    }

    private suspend fun getResponse(): ArrayList<Data>{
        return withContext(Dispatchers.IO)  {
            APIClient.retrofitBuilder.getDataCoroutine().body()?.usersList as ArrayList<Data>
        }
    }
}