package com.example.lab_exam_2

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ConsultationActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var gridSpecializations: GridLayout
    private lateinit var btnCheckAvailability: Button

    private val specializations = arrayOf(
        "Cardiology", "Dermatology", "Endocrinology",
        "Gastroenterology", "Neurology", "Psychiatry", "General"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultation)

        // Setup action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Doctor Consultation"

        initViews()
        setupSpecializationGrid()
        setupClickListeners()
    }

    private fun initViews() {
        tvTitle = findViewById(R.id.tvTitle)
        gridSpecializations = findViewById(R.id.gridSpecializations)
        btnCheckAvailability = findViewById(R.id.btnCheckAvailability)
    }

    private fun setupSpecializationGrid() {
        for (specialization in specializations) {
            val cardView = CardView(this)
            val layoutParams = GridLayout.LayoutParams()
            layoutParams.width = 0
            layoutParams.height = GridLayout.LayoutParams.WRAP_CONTENT
            layoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            layoutParams.setMargins(8, 8, 8, 8)
            cardView.layoutParams = layoutParams
            cardView.cardElevation = 4f
            cardView.radius = 8f

            val textView = TextView(this)
            textView.text = specialization
            textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            textView.setPadding(16, 24, 16, 24)
            textView.textSize = 14f

            cardView.addView(textView)
            cardView.setOnClickListener {
                Toast.makeText(this, "Selected: $specialization", Toast.LENGTH_SHORT).show()
            }

            gridSpecializations.addView(cardView)
        }
    }

    private fun setupClickListeners() {
        btnCheckAvailability.setOnClickListener {
            Toast.makeText(this, "Checking availability for consultation...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
