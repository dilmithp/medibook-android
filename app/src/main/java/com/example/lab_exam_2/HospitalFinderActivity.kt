package com.example.lab_exam_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HospitalFinderActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var etSearchArea: EditText
    private lateinit var btnSearchArea: Button
    private lateinit var rvHospitals: RecyclerView

    // Sample hospital data
    private val hospitals = listOf(
        "General Hospital OPD - Open",
        "National Hospital Sri Lanka - Open",
        "Asiri Hospital - Colombo",
        "Nawaloka Hospital - Colombo",
        "Lanka Hospital - Colombo"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_finder)

        // Setup action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Find Hospitals"

        initViews()
        setupRecyclerView()
        setupClickListeners()
    }

    private fun initViews() {
        tvTitle = findViewById(R.id.tvTitle)
        etSearchArea = findViewById(R.id.etSearchArea)
        btnSearchArea = findViewById(R.id.btnSearchArea)
        rvHospitals = findViewById(R.id.rvHospitals)
    }

    private fun setupRecyclerView() {
        rvHospitals.layoutManager = LinearLayoutManager(this)
        // Here you would set up your hospital adapter
        Toast.makeText(this, "Showing ${hospitals.size} hospitals nearby", Toast.LENGTH_SHORT).show()
    }

    private fun setupClickListeners() {
        btnSearchArea.setOnClickListener {
            val area = etSearchArea.text.toString().trim()
            if (area.isNotEmpty()) {
                Toast.makeText(this, "Searching hospitals in: $area", Toast.LENGTH_SHORT).show()
            } else {
                etSearchArea.error = "Please enter an area to search"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
