package com.example.vehiclehealthmonitor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vehiclehealthmonitoringsystem.HomeActivity
import com.example.vehiclehealthmonitoringsystem.R
import com.example.vehiclehealthmonitoringsystem.ServiceActivity

class MainActivity : AppCompatActivity() {

    private lateinit var homeTextView: TextView
    private lateinit var startBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeTextView = findViewById(R.id.home)
        startBtn = findViewById(R.id.startbtn)

        homeTextView.setOnClickListener {
            // Handle click for Home TextView
            //  navigate to HomeActivity
            val homeIntent = Intent(this, HomeActivity::class.java)
            startActivity(homeIntent)
        }

        startBtn.setOnClickListener {
            // Handle click for Send Service Request Button
            // navigate to ServiceRequestActivity
            val serviceRequestIntent = Intent(this, ServiceActivity::class.java)
            startActivity(serviceRequestIntent)
        }
    }
}
