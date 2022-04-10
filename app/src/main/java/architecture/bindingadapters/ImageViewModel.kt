package architecture.bindingadapters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel: ViewModel() {

    val image = MutableLiveData<ImageInfo>()
    init {
        image.value = ImageInfo("Nature","https://i.picsum.photos/id/301/200/200.jpg?hmac=8LBy-lxo8NF1vIabeRaqqBVpr2XpkwTzOSpicYy8YSU")
    }

}