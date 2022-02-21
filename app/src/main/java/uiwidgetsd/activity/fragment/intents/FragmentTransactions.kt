package uiwidgetsd.activity.fragment.intents

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityFragmentTransactionsBinding

class FragmentTransactions : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentTransactionsBinding
    private val fragmentManager = supportFragmentManager

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transactions)

        binding = ActivityFragmentTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            binding.status.text = add(FragmentA(), "A")
        }
        binding.btn2.setOnClickListener {
            binding.status.text = remove1("A")
        }
        binding.btn3.setOnClickListener {
            binding.status2.text = add(FragmentB(), "B")
        }
        binding.btn4.setOnClickListener {
            binding.status2.text = remove1("B")
        }
        binding.btn5.setOnClickListener {
            fragmentManager.commit {
                binding.status2.text = "Fragment A by B"
                replace(R.id.container111, FragmentB(), "B")
            }
        }
        binding.btn6.setOnClickListener {
            val f1 = fragmentManager.findFragmentByTag("A")
            fragmentManager.commit {
                f1?.let { it1 ->
                    detach(it1)
                    binding.status.text = "Fragment A is: Detached"
                } ?: run {
                    binding.status.text = "Fragment A is not added before"
                }
            }
        }
    }

    private fun remove1(tag: String): String {
        val f1 = fragmentManager.findFragmentByTag(tag)
        var result = "NULL"
        fragmentManager.commit {
            f1?.let { it1 ->
                remove(it1)
                result = "Fragment $tag is: removed"
            } ?: run {
                result = "Fragment $tag is not added before"
            }
        }
        return result
    }

    private fun add(fragment: Fragment, tag: String): String {
        var result = "NULL"
        fragmentManager.commit {
            add(R.id.container111, fragment, tag)
            result = "Fragment $tag is: Added"
        }
        return result
    }

}

