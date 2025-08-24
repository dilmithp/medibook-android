package com.example.lab_exam_2

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var tvWelcomeUser: TextView
    private lateinit var cardDoctorBooking: CardView
    private lateinit var cardOrderMedicine: CardView
    private lateinit var cardConsultation: CardView
    private lateinit var cardHospitalFinder: CardView
    private lateinit var cardPharmacy: CardView
    private lateinit var cardMealPlan: CardView
    private lateinit var tvProfile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupClickListeners()
        setupWelcomeMessage()
    }

    private fun initViews() {
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser)
        cardDoctorBooking = findViewById(R.id.cardDoctorBooking)
        cardOrderMedicine = findViewById(R.id.cardOrderMedicine)
        cardConsultation = findViewById(R.id.cardConsultation)
        cardHospitalFinder = findViewById(R.id.cardHospitalFinder)
        cardPharmacy = findViewById(R.id.cardPharmacy)
        cardMealPlan = findViewById(R.id.cardMealPlan)
        tvProfile = findViewById(R.id.tvProfile)
    }

    private fun setupClickListeners() {
        cardDoctorBooking.setOnClickListener {
            startActivity(Intent(this, DoctorBookingActivity::class.java))
        }

        cardOrderMedicine.setOnClickListener {
            startActivity(Intent(this, MedicineOrderActivity::class.java))
        }

        cardConsultation.setOnClickListener {
            startActivity(Intent(this, ConsultationActivity::class.java))
        }

        cardHospitalFinder.setOnClickListener {
            startActivity(Intent(this, HospitalFinderActivity::class.java))
        }

        cardPharmacy.setOnClickListener {
            startActivity(Intent(this, PharmacyActivity::class.java))
        }

        cardMealPlan.setOnClickListener {
            startActivity(Intent(this, MealPlanActivity::class.java))
        }

        tvProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun setupWelcomeMessage() {
        tvWelcomeUser.text = "Welcome, Dilmith"
    }

    override fun onBackPressed() {
        // Show exit confirmation
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
        super.onBackPressed()
    }
}
