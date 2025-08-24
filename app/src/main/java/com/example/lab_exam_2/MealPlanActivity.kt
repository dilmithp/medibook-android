package com.example.lab_exam_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MealPlanActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var etAge: EditText
    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var etHealthIssues: EditText
    private lateinit var btnGenerateMealPlan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_plan)

        // Setup action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Meal Plan Generator"

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        tvTitle = findViewById(R.id.tvTitle)
        etAge = findViewById(R.id.etAge)
        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        etHealthIssues = findViewById(R.id.etHealthIssues)
        btnGenerateMealPlan = findViewById(R.id.btnGenerateMealPlan)
    }

    private fun setupClickListeners() {
        btnGenerateMealPlan.setOnClickListener {
            if (validateFields()) {
                generateMealPlan()
            }
        }
    }

    private fun validateFields(): Boolean {
        val age = etAge.text.toString().trim()
        val weight = etWeight.text.toString().trim()
        val height = etHeight.text.toString().trim()

        return when {
            age.isEmpty() -> {
                etAge.error = "Please enter your age"
                false
            }
            weight.isEmpty() -> {
                etWeight.error = "Please enter your weight"
                false
            }
            height.isEmpty() -> {
                etHeight.error = "Please enter your height"
                false
            }
            else -> true
        }
    }

    private fun generateMealPlan() {
        val age = etAge.text.toString()
        val weight = etWeight.text.toString()
        val height = etHeight.text.toString()
        val healthIssues = etHealthIssues.text.toString()

        Toast.makeText(
            this,
            "Generating personalized meal plan for age: $age, weight: $weight kg, height: $height cm",
            Toast.LENGTH_LONG
        ).show()

        // Here you would typically generate or fetch a meal plan
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
