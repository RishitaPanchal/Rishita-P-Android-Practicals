package architecture.bindingadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.kotlin_java_practicalss.databinding.ActivityLoadImageViewBinding

class LoadImageView : AppCompatActivity() {

    private lateinit var binding: ActivityLoadImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

}

@BindingAdapter("loadImage")
fun bindingImage(imageView: ImageView, imageUri: String) {
    Glide.with(imageView.context)
        .load(imageUri)
        .into(imageView)
}