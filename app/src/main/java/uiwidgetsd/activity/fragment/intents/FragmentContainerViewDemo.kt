package uiwidgetsd.activity.fragment.intents

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityFragmentContainerViewDemoBinding

class FragmentContainerViewDemo : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentContainerViewDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container_view_demo)

        binding = ActivityFragmentContainerViewDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, FragmentNavigationOne::class.java, null).commit()
    }

    fun loadFragmentA(view: View) = replaceFragment(FragmentNavigationOne())
    fun loadFragmentB(view: View) =  replaceFragment(FragmentNavigationTwo())
    fun loadFragmentC(view: View) = replaceFragment(FragmentNavigationThree())

    private fun replaceFragment(fragment: Fragment) {
        fragment.let {
            val transactions = supportFragmentManager.beginTransaction()
            transactions.replace(R.id.fragmentContainer, fragment)
            transactions.addToBackStack(null)
            transactions.commit()
        }
    }

}