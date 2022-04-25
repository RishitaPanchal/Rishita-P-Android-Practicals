package design.support.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.kotlin_java_practicalss.R
import com.example.kotlin_java_practicalss.databinding.ActivityNavigationViewBinding

class NavigationView : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityNavigationViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawableLayout, R.string.open, R.string.close)
        binding.drawableLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(this, getString(R.string.home), Toast.LENGTH_LONG).show()
                R.id.nav_message -> Toast.makeText(this, getString(R.string.message), Toast.LENGTH_LONG).show()
                R.id.nav_sync -> Toast.makeText(this, getString(R.string.sync), Toast.LENGTH_LONG).show()
                R.id.nav_setting -> Toast.makeText(this, getString(R.string.settings), Toast.LENGTH_LONG).show()
                R.id.nav_profile1 -> Toast.makeText(this, getString(R.string.profile), Toast.LENGTH_LONG).show()
                else -> Toast.makeText(this, getString(R.string.not_found), Toast.LENGTH_LONG).show()
            }
            true
        }
    }


   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}