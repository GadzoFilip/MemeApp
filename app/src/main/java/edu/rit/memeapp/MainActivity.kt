package edu.rit.memeapp

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import edu.rit.memeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val navBarConfiguration = AppBarConfiguration(setOf(
        R.id.memeListFragment,
        R.id.memeFavoritesFragment,
        R.id.memeCreateFragment,
        R.id.memeCreateListFragment
    ))

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

        binding.bottomNav.setupWithNavController(navController)
        setupActionBarWithNavController(navController, navBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, bundle ->
            when (destination.id) {
                R.id.memeListFragment,
                R.id.memeCreateFragment -> binding.bottomNav.visibility = View.VISIBLE
                R.id.memeCreateListFragment -> binding.bottomNav.visibility = View.VISIBLE
                R.id.memeFavoritesFragment -> binding.bottomNav.visibility = View.VISIBLE
                R.id.memeDetailFragment -> binding.bottomNav.visibility = View.GONE
            }
        }
    }
}