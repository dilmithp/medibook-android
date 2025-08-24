package com.example.lab_exam_2


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvProfileTitle: TextView
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvAge: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvBloodGroup: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Setup action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "User Profile"

        initViews()
        setupProfileData()
        setupClickListeners()
    }

    private fun initViews() {
        tvProfileTitle = findViewById(R.id.tvProfileTitle)
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvAge = findViewById(R.id.tvAge)
        tvPhone = findViewById(R.id.tvPhone)
        tvAddress = findViewById(R.id.tvAddress)
        tvBloodGroup = findViewById(R.id.tvBloodGroup)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }

    private fun setupProfileData() {
        tvName.text = "Name: Dilmith Pathirana"
        tvEmail.text = "Email: x@dilmith.live"
        tvAge.text = "Age: 22"
        tvPhone.text = "Phone Number: 0777736627"
        tvAddress.text = "Address: 39/A, Kandy Rd, Malabe"
        tvBloodGroup.text = "Blood Group: O-"
    }

    private fun setupClickListeners() {
        btnUpdate.setOnClickListener {
            Toast.makeText(this, "Profile Update Feature Coming Soon!", Toast.LENGTH_SHORT).show()
        }

        btnDelete.setOnClickListener {
            Toast.makeText(this, "Profile Delete Feature Coming Soon!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
