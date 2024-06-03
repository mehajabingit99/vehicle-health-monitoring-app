package com.example.vehiclehealthmonitoringsystem

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {

    private lateinit var mFullName: EditText
    private lateinit var mUsername: EditText
    private lateinit var mEmail: EditText
    private lateinit var mPassword: EditText
    private lateinit var mRegisterBtn: Button
    private lateinit var mLoginBtn: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // define all fields by findViewById()
        mFullName = findViewById(R.id.fullname)
        mUsername = findViewById(R.id.username)
        mEmail = findViewById(R.id.email)
        mPassword = findViewById(R.id.password)
        mRegisterBtn = findViewById(R.id.registerbtn)
        mLoginBtn = findViewById(R.id.createtext)


        mLoginBtn.setOnClickListener {
            startActivity(Intent(applicationContext, Login::class.java))
        }

        mRegisterBtn.setOnClickListener {
            val email = mEmail.text.toString().trim()
            val password = mPassword.text.toString().trim()
            val fullName = mFullName.text.toString()
            val username = mUsername.text.toString()

            if (TextUtils.isEmpty(email)) {
                mEmail.error = "Email is required"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)) {
                mPassword.error = "Password is required"
                return@setOnClickListener
            }

            if (password.length < 6) {
                mPassword.error = "Password must be >= 6 characters"
                return@setOnClickListener
            }


        }
    }
}
