package com.example.p7_bhanwar_19012011094

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.p7_bhanwar_19012011094.Logininfo.Companion.email
import com.example.p7_bhanwar_19012011094.Logininfo.Companion.password
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)
        setStatusBarTransparent()

        val login_button = findViewById<Button>(R.id.loginbutton)
        val signup_button = findViewById<Button>(R.id.signupbtn)
        val email_login = findViewById<TextInputEditText>(R.id.mainLoginEmailId)
        val passwor_login = findViewById<TextInputEditText>(R.id.mainpasswordLogin)

        signup_button.setOnClickListener {
            Intent(this, Registration::class.java).apply {
                startActivity(this)
            }
        }
        login_button.setOnClickListener {
            var email_input = email_login.text.toString()
            var password_input = passwor_login.text.toString()
            if (email_input == email && password_input == password.toString()) {
                Intent(this,DashBoard::class.java).apply {
                    startActivity(this)
                }
            }
            else {
                Toast.makeText(applicationContext,"Enter valid email or password", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT in 19..20) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val winParameters = window.attributes
        if (on) {
            winParameters.flags = winParameters.flags or bits
        }
        else {
            winParameters.flags = winParameters.flags and bits.inv()
        }
        window.attributes = winParameters
    }
}