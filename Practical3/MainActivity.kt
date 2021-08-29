package com.example.practical_3_19012011094

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "onCreate method is called.",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"onCreate method is called.")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart method is called.",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"onStart method is called.")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart method is called.",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"onRestart method is called.")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume method is called.",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"onResume method is called.")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause method is called.",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"onPause method is called.")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop method is called.",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"onStop method is called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy method is called.",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"onDestroy method is called.")
    }
}