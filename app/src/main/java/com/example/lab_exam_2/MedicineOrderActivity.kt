package com.example.lab_exam_2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MedicineOrderActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvSubtitle: TextView
    private lateinit var cardPrescriptions: CardView
    private lateinit var cardMyMedicine: CardView
    private lateinit var cardRequests: CardView
    private lateinit var tvUploadDescription: TextView
    private lateinit var btnUploadNow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine_order)

        // Setup action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Medicine Orders"

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        tvTitle = findViewById(R.id.tvTitle)
        tvSubtitle = findViewById(R.id.tvSubtitle)
        cardPrescriptions = findViewById(R.id.cardPrescriptions)
        cardMyMedicine = findViewById(R.id.cardMyMedicine)
        cardRequests = findViewById(R.id.cardRequests)
        tvUploadDescription = findViewById(R.id.tvUploadDescription)
        btnUploadNow = findViewById(R.id.btnUploadNow)
    }

    private fun setupClickListeners() {
        cardPrescriptions.setOnClickListener {
            Toast.makeText(this, "Loading Prescriptions...", Toast.LENGTH_SHORT).show()
        }

        cardMyMedicine.setOnClickListener {
            Toast.makeText(this, "Loading My Medicines...", Toast.LENGTH_SHORT).show()
        }

        cardRequests.setOnClickListener {
            startActivity(android.content.Intent(this, HistoryActivity::class.java))
        }

        btnUploadNow.setOnClickListener {
            Toast.makeText(this, "Upload prescription feature coming soon!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
