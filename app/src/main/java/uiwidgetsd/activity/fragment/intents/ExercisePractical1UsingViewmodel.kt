package uiwidgetsd.activity.fragment.intents

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.transaction
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityExercisePractical1UsingViewmodelBinding

class ExercisePractical1UsingViewmodel : AppCompatActivity() {

    private lateinit var binding: ActivityExercisePractical1UsingViewmodelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_practical1_using_viewmodel)
        binding = ActivityExercisePractical1UsingViewmodelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment(GallaryFragment(), R.id.fragmentContainer)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.gallary -> initFragment(GallaryFragment(), R.id.fragmentContainer)
                R.id.addMessage -> initFragment(AddMessageFragment(), R.id.fragmentContainer)
                R.id.viewMessage -> initFragment(ViewMessageFragment(), R.id.fragmentContainer)
            }
            true
        }
    }

}

private fun AppCompatActivity.initFragment(fragment: Fragment, container: Int) {
    val transactions = supportFragmentManager.beginTransaction()
    transactions.replace(container, fragment)
    transactions.addToBackStack(null)
    transactions.commit()
}

