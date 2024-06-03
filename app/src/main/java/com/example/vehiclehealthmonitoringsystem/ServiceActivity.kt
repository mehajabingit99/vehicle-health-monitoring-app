package com.example.vehiclehealthmonitoringsystem
import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ServiceActivity : AppCompatActivity() {
    private var fullNameEditText: EditText? = null
    private var emailEditText: EditText? = null
    private var contactEditText: EditText? = null
    private var vNameEditText: EditText? = null
    private var vModelEditText: EditText? = null
    private var vBrandEditText: EditText? = null
    private var regNoEditText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        fullNameEditText = findViewById<EditText>(R.id.fullname)
        emailEditText = findViewById<EditText>(R.id.email)
        contactEditText = findViewById<EditText>(R.id.contact)
        vNameEditText = findViewById<EditText>(R.id.vname)
        vModelEditText = findViewById<EditText>(R.id.vmodel)
        vBrandEditText = findViewById<EditText>(R.id.vbrand)
        regNoEditText = findViewById<EditText>(R.id.regno)
        val submitButton = findViewById<Button>(R.id.btn)
        submitButton.setOnClickListener {
            if (validateForm()) {
                // Gather form data
                val fullName = fullNameEditText.getText().toString()
                val email = emailEditText.getText().toString()
                val contact = contactEditText.getText().toString()
                val vName = vNameEditText.getText().toString()
                val vModel = vModelEditText.getText().toString()
                val vBrand = vBrandEditText.getText().toString()
                val regNo = regNoEditText.getText().toString()

                // Mock vehicle health status and error (In real scenario, this would be fetched from a backend service)
                val status =
                    "Engine: Operational\nBattery: Good\nFuel Level: 75%\nOil Level: Sufficient\nTire Pressure: Normal\nBrake System: Good\nTransmission: Smooth\nCoolant Level: Normal"
                val error = "Low tire pressure on rear left tire"

                // Start the health status activity and pass the data
                val intent = Intent(
                    this@ServiceActivity,
                    HealthStatusActivity::class.java
                )
                intent.putExtra("status", status)
                intent.putExtra("error", error)
                startActivity(intent)
            }
        }
    }

    private fun validateForm(): Boolean {
        if (fullNameEditText!!.getText().toString().isEmpty()) {
            Toast.makeText(this, "Full Name is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (emailEditText!!.getText().toString().isEmpty()) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (contactEditText!!.getText().toString().isEmpty()) {
            Toast.makeText(this, "Contact is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (vNameEditText!!.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vehicle Name is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (vModelEditText!!.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vehicle Model is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (vBrandEditText!!.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vehicle Brand is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (regNoEditText!!.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vehicle Registration Number is required", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }
}
