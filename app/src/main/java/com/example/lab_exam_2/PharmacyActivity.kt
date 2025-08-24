package com.example.lab_exam_2

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PharmacyActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var rvPharmacies: RecyclerView

    // Sample pharmacy data
    private val pharmacies = listOf(
        "ProHealth PVT LTD",
        "Raavi PVT LTD",
        "Chemist PVT LTD",
        "AVD PVT LTD",
        "Asiri PVT LTD",
        "KKP PVT LTD"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pharmacy)

        // Setup action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Nearby Pharmacies"

        initViews()
        setupRecyclerView()
    }

    private fun initViews() {
        tvTitle = findViewById(R.id.tvTitle)
        rvPharmacies = findViewById(R.id.rvPharmacies)
    }

    private fun setupRecyclerView() {
        rvPharmacies.layoutManager = GridLayoutManager(this, 2)
        // Here you would set up your pharmacy adapter
        Toast.makeText(this, "Showing ${pharmacies.size} recommended pharmacies", Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
