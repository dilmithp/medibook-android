package com.example.lab_exam_2

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView
import java.util.*

class MainActivity : AppCompatActivity() {

    // UI Components
    private lateinit var collapsingToolbar: CollapsingToolbarLayout
    private lateinit var tvWelcomeUser: TextView
    private lateinit var ivNotifications: ImageView
    private lateinit var etSearch: EditText
    private lateinit var cardDoctorBooking: MaterialCardView
    private lateinit var cardOrderMedicine: MaterialCardView
    private lateinit var cardConsultation: MaterialCardView
    private lateinit var cardHospitalFinder: MaterialCardView
    private lateinit var cardPharmacy: MaterialCardView
    private lateinit var cardMealPlan: MaterialCardView
    private lateinit var layoutProfile: LinearLayout
    private lateinit var bottomNavigation: BottomNavigationView

    // Vibrator for haptic feedback
    private lateinit var vibrator: Vibrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize vibrator
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        initViews()
        setupWelcomeMessage()
        setupClickListeners()
        setupEnhancedBottomNavigation()
        setupHeaderActions()
        setupBackPressHandler()

        // Animate cards entry with delay
        Handler(Looper.getMainLooper()).postDelayed({
            animateCardsEntry()
        }, 300)
    }

    private fun initViews() {
        collapsingToolbar = findViewById(R.id.collapsingToolbar)
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser)
        ivNotifications = findViewById(R.id.ivNotifications)
        etSearch = findViewById(R.id.etSearch)
        cardDoctorBooking = findViewById(R.id.cardDoctorBooking)
        cardOrderMedicine = findViewById(R.id.cardOrderMedicine)
        cardConsultation = findViewById(R.id.cardConsultation)
        cardHospitalFinder = findViewById(R.id.cardHospitalFinder)
        cardPharmacy = findViewById(R.id.cardPharmacy)
        cardMealPlan = findViewById(R.id.cardMealPlan)
        layoutProfile = findViewById(R.id.layoutProfile)
        bottomNavigation = findViewById(R.id.bottom_navigation)
    }

    private fun setupWelcomeMessage() {
        val prefs = getSharedPreferences("MediBookPrefs", Context.MODE_PRIVATE)
        val userName = prefs.getString("userName", "User") ?: "User"

        val greeting = getGreeting()

        // Dynamic greeting with user name
        val welcomeMessage = "$greeting, $userName!"
        tvWelcomeUser.text = welcomeMessage

        // Add subtle animation to welcome text
        tvWelcomeUser.alpha = 0f
        tvWelcomeUser.animate()
            .alpha(1f)
            .setDuration(800)
            .setInterpolator(DecelerateInterpolator())
            .start()
    }

    private fun getGreeting(): String {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (hour) {
            in 6..11 -> "Good Morning"
            in 12..17 -> "Good Afternoon"
            in 18..21 -> "Good Evening"
            else -> "Hello"
        }
    }

    private fun setupClickListeners() {
        cardDoctorBooking.setOnClickListener { view ->
            performHapticFeedback()
            animateCardClickEnhanced(view) {
                navigateWithAnimation(Intent(this, DoctorBookingActivity::class.java))
            }
        }

        cardOrderMedicine.setOnClickListener { view ->
            performHapticFeedback()
            animateCardClickEnhanced(view) {
                navigateWithAnimation(Intent(this, MedicineOrderActivity::class.java))
            }
        }

        cardConsultation.setOnClickListener { view ->
            performHapticFeedback()
            animateCardClickEnhanced(view) {
                navigateWithAnimation(Intent(this, ConsultationActivity::class.java))
            }
        }

        cardHospitalFinder.setOnClickListener { view ->
            performHapticFeedback()
            animateCardClickEnhanced(view) {
                navigateWithAnimation(Intent(this, HospitalFinderActivity::class.java))
            }
        }

        cardPharmacy.setOnClickListener { view ->
            performHapticFeedback()
            animateCardClickEnhanced(view) {
                navigateWithAnimation(Intent(this, PharmacyActivity::class.java))
            }
        }

        cardMealPlan.setOnClickListener { view ->
            performHapticFeedback()
            animateCardClickEnhanced(view) {
                navigateWithAnimation(Intent(this, MealPlanActivity::class.java))
            }
        }

        layoutProfile.setOnClickListener {
            performHapticFeedback()
            navigateWithAnimation(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun setupHeaderActions() {
        // Search functionality - Simple toast for demo
        etSearch.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showToast("Search functionality coming soon!")
                etSearch.clearFocus()
            }
        }

        etSearch.setOnClickListener {
            showToast("Search functionality coming soon!")
        }

        // Notifications
        ivNotifications.setOnClickListener {
            performHapticFeedback()
            showNotifications()
        }
    }

    private fun animateCardClickEnhanced(view: View, action: () -> Unit) {
        // Enhanced animation with bounce effect
        view.animate()
            .scaleX(0.94f)
            .scaleY(0.94f)
            .setDuration(100)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(200)
                    .setInterpolator(OvershootInterpolator(1.2f))
                    .start()

                Handler(Looper.getMainLooper()).postDelayed({
                    action()
                }, 100)
            }
            .start()
    }

    private fun animateCardsEntry() {
        val cards = listOf(
            cardDoctorBooking,
            cardOrderMedicine,
            cardConsultation,
            cardHospitalFinder,
            cardPharmacy,
            cardMealPlan
        )

        cards.forEachIndexed { index, card ->
            card.alpha = 0f
            card.translationY = 120f
            card.scaleX = 0.8f
            card.scaleY = 0.8f

            card.animate()
                .alpha(1f)
                .translationY(0f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(500)
                .setStartDelay(index * 100L)
                .setInterpolator(OvershootInterpolator(0.8f))
                .start()
        }
    }

    private fun setupEnhancedBottomNavigation() {
        bottomNavigation.selectedItemId = R.id.nav_home

        // Enhanced item selection listener with animations and feedback
        bottomNavigation.setOnItemSelectedListener { item ->
            performHapticFeedback()

            when (item.itemId) {
                R.id.nav_home -> {
                    // Already on home - show bounce animation
                    bounceSelectedTab(bottomNavigation)
                    true
                }
                R.id.nav_appointments -> {
                    navigateWithBottomNavAnimation {
                        startActivity(Intent(this, HistoryActivity::class.java))
                    }
                    true
                }
                R.id.nav_medicines -> {
                    navigateWithBottomNavAnimation {
                        startActivity(Intent(this, MedicineOrderActivity::class.java))
                    }
                    true
                }
                R.id.nav_profile -> {
                    navigateWithBottomNavAnimation {
                        startActivity(Intent(this, ProfileActivity::class.java))
                    }
                    true
                }
                else -> false
            }
        }

        // Handle reselection (when same tab is tapped again)
        bottomNavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Scroll to top or refresh
                    scrollToTop()
                }
                else -> {
                    // Show bounce animation for other tabs
                    bounceSelectedTab(bottomNavigation)
                }
            }
        }
    }

    private fun setupBackPressHandler() {
        // Modern back press handling (replaces deprecated onBackPressed)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (isTaskRoot) {
                    showExitConfirmation()
                } else {
                    finish()
                }
            }
        })
    }

    private fun performHapticFeedback() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(50)
            }
        } catch (e: Exception) {
            // Handle vibration not available - no crash
        }
    }

    private fun navigateWithAnimation(intent: Intent) {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
        }, 100)
    }

    private fun navigateWithBottomNavAnimation(action: () -> Unit) {
        bottomNavigation.animate()
            .scaleX(0.95f)
            .scaleY(0.95f)
            .setDuration(100)
            .withEndAction {
                bottomNavigation.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(150)
                    .start()

                Handler(Looper.getMainLooper()).postDelayed({
                    action()
                }, 50)
            }
            .start()
    }

    private fun bounceSelectedTab(view: View) {
        view.animate()
            .scaleX(1.05f)
            .scaleY(1.05f)
            .setDuration(100)
            .withEndAction {
                view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(100)
                    .start()
            }
            .start()
    }

    private fun scrollToTop() {
        // Simple feedback without scrolling
        showToast("Scrolled to top")
    }


    private fun showNotifications() {
        // Enhanced notifications with badge and animation
        val notificationCount = getNotificationCount()

        if (notificationCount > 0) {
            showToast("You have $notificationCount new notifications")
            // Simple notification display for demo
        } else {
            showToast("No new notifications")
        }

        // Animate notification icon
        ivNotifications.animate()
            .rotationY(360f)
            .setDuration(500)
            .start()
    }

    private fun getNotificationCount(): Int {
        val prefs = getSharedPreferences("MediBookPrefs", Context.MODE_PRIVATE)
        return prefs.getInt("notification_count", 3) // Default 3 for demo
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showExitConfirmation() {
        Toast.makeText(this, "Press back again to exit MediBook", Toast.LENGTH_SHORT).show()

        // Simple exit confirmation - you can enhance this with a dialog
        Handler(Looper.getMainLooper()).postDelayed({
            // Reset after 2 seconds
        }, 2000)
    }

    override fun onResume() {
        super.onResume()
        setupWelcomeMessage()
        bottomNavigation.selectedItemId = R.id.nav_home

        // Refresh any dynamic data
        refreshDashboardData()
    }

    private fun refreshDashboardData() {
        // Refresh dashboard data like appointment counts, health stats, etc.
        // This method can be expanded for API calls when needed
    }

    // Save user preferences on pause
    override fun onPause() {
        super.onPause()
        val prefs = getSharedPreferences("MediBookPrefs", Context.MODE_PRIVATE)
        prefs.edit()
            .putLong("last_active", System.currentTimeMillis())
            .apply()
    }
}
