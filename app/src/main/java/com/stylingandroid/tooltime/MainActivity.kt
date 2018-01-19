package com.stylingandroid.tooltime

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        replaceFragment(Part1Fragment::class.java.canonicalName)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener when (item.itemId) {
            R.id.navigation_one -> {
                replaceFragment(Part1Fragment::class.java.canonicalName)
                true
            }
            R.id.navigation_two -> {
                replaceFragment(Part2Fragment::class.java.canonicalName)
                true
            }
            else -> false
        }
    }

    private fun replaceFragment(className: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, Fragment.instantiate(this@MainActivity, className))
            commit()
        }
    }

}
