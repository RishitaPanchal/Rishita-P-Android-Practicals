package architecture.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_java_practicalss.databinding.ActivityCardMvpBinding

class CardMVP : AppCompatActivity(), ICardView {

    private lateinit var binding: ActivityCardMvpBinding
    private val cardController = CardController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

}