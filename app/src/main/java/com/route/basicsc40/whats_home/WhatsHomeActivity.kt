package com.route.basicsc40.whats_home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.basicsc40.R
import com.route.basicsc40.databinding.ActivityWhatsHomeBinding
import com.route.basicsc40.whats_home.tabs.CallsFragment
import com.route.basicsc40.whats_home.tabs.ChatFragment
import com.route.basicsc40.whats_home.tabs.StatusFragment

class WhatsHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWhatsHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatsHomeBinding.inflate(layoutInflater)
        showFragment(ChatFragment(), false)
        setContentView(binding.main)
        binding.chatTab.setOnClickListener {
            showFragment(ChatFragment())
        }
        binding.callsTab.setOnClickListener {
            showFragment(CallsFragment())
        }
        binding.statusTab.setOnClickListener {
            showFragment(StatusFragment())
        }
    }

    fun showFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        if (addToBackStack) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

    }
}