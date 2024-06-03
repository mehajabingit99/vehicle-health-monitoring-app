package com.example.vehiclehealthmonitoringsystem

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vehiclehealthmonitor.MainActivity

class Login : AppCompatActivity() {

    private lateinit var mEmail: EditText
    private lateinit var mPassword: EditText
    private lateinit var mLoginBtn: Button
    private lateinit var mCreateBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mEmail = findViewById(R.id.email)
        mPassword = findViewById(R.id.password)
        mLoginBtn = findViewById(R.id.loginBtn)
        mCreateBtn = findViewById(R.id.createtext)

        mCreateBtn.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        mLoginBtn.setOnClickListener {
            val email = mEmail.text.toString().trim()
            val password = mPassword.text.toString().trim()

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
