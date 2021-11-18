package com.example.prac_5_19012011094

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    enum class EMusic {
        PLAY,
        PAUSE
    }
    var flag = EMusic.PLAY //song is playing
    private val TAG = "MainActivity"
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Play-button
        val playBtn = findViewById<FloatingActionButton>(R.id.playbtn)
        playBtn.setOnClickListener{
            Log.i(TAG, "buttonplayonclick")
            Intent(applicationContext, MusicService::class.java).putExtra("service", "play/pause" ).apply {
                startService(this) }
            if (flag==EMusic.PLAY){
                setPause()
                flag = EMusic.PAUSE
            }
            else{
                setPlay()
                flag = EMusic.PLAY
            }
        }

        //Stop-button
        val stopBtn = findViewById<FloatingActionButton>(R.id.stopbtn)
        stopBtn.setOnClickListener{
            Intent(applicationContext, MusicService::class.java).apply {
                stopService(this) }
            setPlay()
        }

        //Fav-button
        val favBtn = findViewById<FloatingActionButton>(R.id.favbtn)
        favBtn.setOnClickListener{
            favBtn.setColorFilter(ContextCompat.getColor(applicationContext, R.color.pink))
        }
    }

    private fun setPause(){
        val playBtn = findViewById<FloatingActionButton>(R.id.playbtn)
        playBtn.setImageResource(R.drawable.ic_pause)
    }

    private fun setPlay(){
        val playBtn = findViewById<FloatingActionButton>(R.id.playbtn)
        playBtn.setImageResource(R.drawable.ic_play)
    }
}