package com.example.praktika11fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.praktika11fragments.databinding.ActivityMainBinding
import com.example.praktika11fragments.fragments.HomeFragment
import com.example.praktika11fragments.fragments.ProfileFragment
import com.example.praktika11fragments.fragments.SupportFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, HomeFragment()).commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mHome    -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment()).commit()
                R.id.mProfile -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, ProfileFragment()).commit()
                R.id.mLogout  -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, SupportFragment()).commit()
                R.id.mExit    -> finish()
            }
            true
        }
    }
}