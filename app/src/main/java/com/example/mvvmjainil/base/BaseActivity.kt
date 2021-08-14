package com.example.mvvmjainil.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.mvvmjainil.R

open class BaseActivity : AppCompatActivity() {

    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager = supportFragmentManager
    }

    fun addFragment(fragment: BaseFragment) {
        manager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        val currentFragment = getCurrentFragment()
        if (currentFragment != null) {
            if (currentFragment.onBack()) {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }

    private fun getCurrentFragment() = manager.findFragmentById(R.id.fragmentContainer) as? BaseFragment
}