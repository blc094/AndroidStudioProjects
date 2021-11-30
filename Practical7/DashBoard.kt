package com.example.p7_bhanwar_19012011094

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.p7_bhanwar_19012011094.Logininfo.Companion.city
import com.example.p7_bhanwar_19012011094.Logininfo.Companion.email
import com.example.p7_bhanwar_19012011094.Logininfo.Companion.fullname
import com.example.p7_bhanwar_19012011094.Logininfo.Companion.phone

class DashBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        getSupportActionBar()?.hide()
        setStatusBarTransparent()

        val fullname_dashboard = findViewById<TextView>(R.id.name_dashboard1)
        val phone_dashboard = findViewById<TextView>(R.id.phone_dashboard1)
        val city_dashboard = findViewById<TextView>(R.id.city_dashboard1)
        val email_dashboard = findViewById<TextView>(R.id.email_dashboard1)
        val email_dashboard_main = findViewById<TextView>(R.id.textviewemail)
        val name_dashboard_main = findViewById<TextView>(R.id.textViewname)

        name_dashboard_main.setText(fullname)
        email_dashboard_main.setText(email)
        fullname_dashboard.setText(fullname)
        phone_dashboard.setText(phone)
        city_dashboard.setText(city)
        email_dashboard.setText(email)
    }

    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT in 19..20) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
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
        }
        else {
            winParameters.flags = winParameters.flags and bits.inv()
        }
        window.attributes = winParameters
    }
}