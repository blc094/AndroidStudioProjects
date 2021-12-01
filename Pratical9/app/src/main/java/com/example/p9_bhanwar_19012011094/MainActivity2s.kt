package com.example.p9_bhanwar_19012011094

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import com.example.p9_bhanwar_19012011094.Login.Companion.city
import com.example.p9_bhanwar_19012011094.Login.Companion.confirm_pass
import com.example.p9_bhanwar_19012011094.Login.Companion.email
import com.example.p9_bhanwar_19012011094.Login.Companion.fullname
import com.example.p9_bhanwar_19012011094.Login.Companion.password
import com.example.p9_bhanwar_19012011094.Login.Companion.phone
import com.google.android.material.textfield.TextInputEditText

class MainActivity2s : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2s)
        setStatusBarTransparent()
        supportActionBar?.hide()

        val signUp=findViewById<Button>(R.id.signupbtn)
        val fullname_signup=findViewById<TextInputEditText>(R.id.Name_signup)
        val phone_signup=findViewById<TextInputEditText>(R.id.Phone_signup)
        val email_signup=findViewById<TextInputEditText>(R.id.Email_signup)
        val city_signup=findViewById<TextInputEditText>(R.id.City_signup)
        val password_signup=findViewById<TextInputEditText>(R.id.Passw_signup)
        val confirm_pass_signup=findViewById<TextInputEditText>(R.id.CnPass_signup)

        signUp.setOnClickListener {

            fullname = fullname_signup.text.toString()
            phone = phone_signup.text.toString()
            email = email_signup.text.toString()
            city = city_signup.text.toString()
            password = password_signup.text.toString()
            confirm_pass = confirm_pass_signup.text.toString()

            if (password == confirm_pass) {
                Intent(this, MainActivity::class.java).apply {
                    startActivity(this)
                }
            } else {
                Toast.makeText(applicationContext,"Password and Confirm Password doesn't match",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT in 19..20){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
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
        } else {
            winParameters.flags = winParameters.flags and bits.inv()
        }
        window.attributes = winParameters
    }
}