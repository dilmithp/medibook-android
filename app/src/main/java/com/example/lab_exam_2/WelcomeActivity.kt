package com.example.lab_exam_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class WelcomeActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var btnNext: Button
    private lateinit var btnSkip: TextView
    private lateinit var btnGetStarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Hide the action bar
        supportActionBar?.hide()

        initViews()
        setupViewPager()
        setupClickListeners()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)
        btnGetStarted = findViewById(R.id.btnGetStarted)
    }

    private fun setupViewPager() {
        val adapter = WelcomeViewPagerAdapter(this)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 1) {
                    btnNext.visibility = android.view.View.GONE
                    btnGetStarted.visibility = android.view.View.VISIBLE
                } else {
                    btnNext.visibility = android.view.View.VISIBLE
                    btnGetStarted.visibility = android.view.View.GONE
                }
            }
        })
    }

    private fun setupClickListeners() {
        btnNext.setOnClickListener {
            viewPager.currentItem = 1
        }

        btnSkip.setOnClickListener {
            navigateToLogin()
        }

        btnGetStarted.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
