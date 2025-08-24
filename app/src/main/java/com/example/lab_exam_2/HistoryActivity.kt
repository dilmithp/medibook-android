package com.example.lab_exam_2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private lateinit var tvAppointmentsTitle: TextView
    private lateinit var tvMedicineTitle: TextView
    private lateinit var rvAppointments: RecyclerView
    private lateinit var rvMedicineRequests: RecyclerView

    // Sample data
    private val appointments = listOf(
        "Dr. Saman Kumara - Time 6:45 PM - Date 10/07/2025 - Asiri Hospital Colombo",
        "Dr. Namal Gunwardane - Time 8:45 PM - Date 10/07/2025 - Hemas Hospital Colombo",
        "Dr. Sachintha K. - Time 6:45 PM - Date 11/07/2025 - Asiri Hospital Colombo"
    )

    private val medicineRequests = listOf(
        "INV-000213-21 - KCC PVT LTD - Store Pickup - LKR 3450.00",
        "INV-000213-23 - KCC PVT LTD - Store Pickup - LKR 7650.00",
        "INV-000213-51 - KCC PVT LTD - Store Pickup - LKR 1450.00"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        // Setup action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "History"

        initViews()
        setupRecyclerViews()
    }

    private fun initViews() {
        tvAppointmentsTitle = findViewById(R.id.tvAppointmentsTitle)
        tvMedicineTitle = findViewById(R.id.tvMedicineTitle)
        rvAppointments = findViewById(R.id.rvAppointments)
        rvMedicineRequests = findViewById(R.id.rvMedicineRequests)
    }

    private fun setupRecyclerViews() {
        // Setup appointments RecyclerView
        rvAppointments.layoutManager = LinearLayoutManager(this)
        // Here you would set up your appointments adapter

        // Setup medicine requests RecyclerView
        rvMedicineRequests.layoutManager = LinearLayoutManager(this)
        // Here you would set up your medicine requests adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
