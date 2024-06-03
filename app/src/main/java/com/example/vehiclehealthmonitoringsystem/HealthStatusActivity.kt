package com.example.vehiclehealthmonitoringsystem
import android.R
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HealthStatusActivity : AppCompatActivity() {
    private var alertBlock: LinearLayout? = null
    private var healthStatus: TextView? = null
    private var errorMessage: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_status)
        alertBlock = findViewById<LinearLayout>(R.id.alertBlock)
        healthStatus = findViewById<TextView>(R.id.healthStatus)
        errorMessage = findViewById<TextView>(R.id.errorMessage)

        // Retrieve data from the Intent
        val intent = intent
        val status = intent.getStringExtra("status")
        val error = intent.getStringExtra("error")
        findViewById<View>(R.id.checkHealthStatusButton).setOnClickListener {
            showHealthStatus(
                status,
                error
            )
        }
    }

    private fun showHealthStatus(status: String?, error: String?) {
        if (status != null && !status.isEmpty()) {
            healthStatus!!.text = status
            alertBlock!!.visibility = View.VISIBLE
        } else {
            alertBlock!!.visibility = View.GONE
        }
        if (error != null && !error.isEmpty()) {
            errorMessage!!.text = error
            errorMessage!!.visibility = View.VISIBLE
        } else {
            errorMessage!!.visibility = View.GONE
        }
    }
}