package architecture.bindingadapters

import android.text.Editable
import android.util.Log
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ImageViewModel: ViewModel() {

    companion object {
        var intValue: Int = 0
    }
    val image = MutableLiveData<ImageInfo>()
    var newValue = "0"

    init {
        image.value = ImageInfo("Nature","https://i.picsum.photos/id/301/200/200.jpg?hmac=8LBy-lxo8NF1vIabeRaqqBVpr2XpkwTzOSpicYy8YSU")
    }

    @BindingAdapter("text")
    fun setText(view: EditText, newValue: String) {
        view.text = newValue.toEditable()
    }

    @InverseBindingAdapter(attribute = "text")
    fun getText(view: EditText): String {
        try {
            newValue = (view.text.toString().toInt() + 20).toString()
            Log.d("msg", newValue)
        }
        catch (e: Exception) {
            Log.d("Exception", "Exception")
        }
        return newValue
     }

    @BindingAdapter("textAttrChanged")
    fun setTextListener(view: EditText, listener: InverseBindingListener) {
        view.doOnTextChanged { _, _, _, _ ->
            listener.onChange()
        }
    }

    private fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

}

