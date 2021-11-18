package com.example.prac_5_19012011094

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService:Service() {
    lateinit var mediaPlayer: MediaPlayer
    override fun onBind(p0:Intent?):IBinder?{
        TODO("Not yet implemented")
    }
    override fun onStartCommand(intent: Intent?, flags:Int, startId:Int):Int{
        if (!this::mediaPlayer.isInitialized){
            mediaPlayer = MediaPlayer.create(this, R.raw.song)
        }
        if (intent != null){
            val data:String?=intent.getStringExtra("service")
            if (data == "play & pause"){
                if (!mediaPlayer.isPlaying){
                    mediaPlayer.start()
                }
                else{
                    mediaPlayer.pause()
                }
            }
        }
        else{
            mediaPlayer.start()
        }
        return START_STICKY
    }
    override fun onDestroy(){
        mediaPlayer.stop()
        super.onDestroy()
    }
}