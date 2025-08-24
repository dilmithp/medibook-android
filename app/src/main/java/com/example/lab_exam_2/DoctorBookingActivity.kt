package com.example.lab_exam_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DoctorBookingActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var etSearchDoctor: EditText
    private lateinit var etSelectHospital: EditText
    private lateinit var etSearchSpecialization: EditText
    private lateinit var etSelectDate: EditText
    private lateinit var btnCheckAvailability: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_booking)

        // Setup action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Doctor Booking"

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        tvTitle = findViewById(R.id.tvTitle)
        etSearchDoctor = findViewById(R.id.etSearchDoctor)
        etSelectHospital = findViewById(R.id.etSelectHospital)
        etSearchSpecialization = findViewById(R.id.etSearchSpecialization)
        etSelectDate = findViewById(R.id.etSelectDate)
        btnCheckAvailability = findViewById(R.id.btnCheckAvailability)
    }

    private fun setupClickListeners() {
        btnCheckAvailability.setOnClickListener {
            if (validateFields()) {
                Toast.makeText(this, "Checking doctor availability...", Toast.LENGTH_SHORT).show()
                // Here you would typically make an API call
            }
        }

        etSelectDate.setOnClickListener {
            // Here you would show a date picker
            Toast.makeText(this, "Date picker feature coming soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateFields(): Boolean {
        val doctor = etSearchDoctor.text.toString().trim()
        val hospital = etSelectHospital.text.toString().trim()
        val specialization = etSearchSpecialization.text.toString().trim()
        val date = etSelectDate.text.toString().trim()

        return when {
            doctor.isEmpty() -> {
                etSearchDoctor.error = "Please search for a doctor"
                false
            }
            hospital.isEmpty() -> {
                etSelectHospital.error = "Please select a hospital"
                false
            }
            specialization.isEmpty() -> {
                etSearchSpecialization.error = "Please select specialization"
                false
            }
            date.isEmpty() -> {
                etSelectDate.error = "Please select a date"
                false
            }
            else -> true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
