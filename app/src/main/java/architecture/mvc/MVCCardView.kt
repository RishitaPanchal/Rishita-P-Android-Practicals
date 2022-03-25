package architecture.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_java_practicalss.databinding.ActivityCardMvcBinding

class MVCCardView : AppCompatActivity() {

    private lateinit var binding: ActivityCardMvcBinding
    private lateinit var model: MVCCardModel
    private lateinit var view: MVCCardView
    private lateinit var controller: MVCCardController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardMvcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        view = MVCCardView()
        model = MVCCardModel(binding.etCardNumber.text.toString(), binding.etCvv.text.toString())
        controller =MVCCardController(model, view)

        binding.add.setOnClickListener {
            controller.setCardNumber(binding.etCardNumber.text.toString())
            controller.setCvv(binding.etCardNumber.text.toString())
            checkStatus()
        }
    }

    private fun checkStatus() {
        val validationMessage = controller.validateCardDetails()
        Toast.makeText(this, validationMessage, Toast.LENGTH_SHORT).show()
    }

}