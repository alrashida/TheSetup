package com.mysus.myfav

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mysus.myfav.databinding.ActivityMainBinding
import com.mysus.myfav.model.Keiginanitem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manageFragment: NavHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment? ?: return
        //step 2
        val navController = manageFragment.navController
        //step 3
        binding.bottomNavigationView.setupWithNavController(navController)


    }



}