package architecture.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlin_java_practicalss.databinding.ActivityCardMvpBinding

class CardMVP : AppCompatActivity(), ICardView, View.OnClickListener {

    private lateinit var binding: ActivityCardMvpBinding
    private val cardController = CardController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
        binding.add.setOnClickListener {
            cardController.onSubmit(binding.etCardNumber.text.toString(),
                binding.etCvv.text.toString())
        }
    }

    override fun success(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun failure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.add.id -> cardController.onSubmit(binding.etCardNumber.text.toString(),
                binding.etCvv.text.toString())
        }
    }

}