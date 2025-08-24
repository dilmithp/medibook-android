package com.example.lab_exam_2

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnSignIn: MaterialButton
    private lateinit var tvSignUp: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Hide the action bar
        supportActionBar?.hide()

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        tvSignUp = findViewById(R.id.tvSignUp)
        progressBar = findViewById(R.id.progressBar)
    }

    private fun setupClickListeners() {
        btnSignIn.setOnClickListener {
            performLogin()
        }

        tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }

    private fun performLogin() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (validateInput(email, password)) {
            showLoading(true)

            // Simulate network call delay
            Handler(Looper.getMainLooper()).postDelayed({
                authenticateUser(email, password)
            }, 1500)
        }
    }

    private fun authenticateUser(email: String, password: String) {
        when {
            email == "admin@medibook.com" && password == "medibook123" -> {
                // Save login state
                val prefs = getSharedPreferences("MediBookPrefs", Context.MODE_PRIVATE)
                prefs.edit().apply {
                    putBoolean("isLoggedIn", true)
                    putString("userEmail", email)
                    putString("userName", "Admin User")
                    apply()
                }

                showLoading(false)
                Toast.makeText(this, "Welcome back, Admin!", Toast.LENGTH_SHORT).show()
                navigateToMain()
            }

            email == "user@example.com" && password == "password" -> {
                // Save login state
                val prefs = getSharedPreferences("MediBookPrefs", Context.MODE_PRIVATE)
                prefs.edit().apply {
                    putBoolean("isLoggedIn", true)
                    putString("userEmail", email)
                    putString("userName", "Demo User")
                    apply()
                }

                showLoading(false)
                Toast.makeText(this, "Welcome back!", Toast.LENGTH_SHORT).show()
                navigateToMain()
            }

            else -> {
                showLoading(false)
                Toast.makeText(this, "Invalid credentials. Try admin@medibook.com / medibook123", Toast.LENGTH_LONG).show()

                // Shake animation for error
                shakeView(etEmail)
                shakeView(etPassword)
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return when {
            email.isEmpty() -> {
                etEmail.error = "Email is required"
                etEmail.requestFocus()
                shakeView(etEmail)
                false
            }
            password.isEmpty() -> {
                etPassword.error = "Password is required"
                etPassword.requestFocus()
                shakeView(etPassword)
                false
            }
            else -> true
        }
    }

    private fun showLoading(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
            btnSignIn.visibility = View.GONE
        } else {
            progressBar.visibility = View.GONE
            btnSignIn.visibility = View.VISIBLE
        }
    }

    private fun shakeView(view: View) {
        val shake = ObjectAnimator.ofFloat(view, "translationX", 0f, 25f, -25f, 25f, -25f, 15f, -15f, 6f, -6f, 0f)
        shake.duration = 600
        shake.start()
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
