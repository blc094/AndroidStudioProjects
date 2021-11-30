package com.example.p8_bhanwar_19012011094

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vd: VideoView = findViewById(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(vd)
        val uri: Uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.video1)
        vd.setMediaController(mediaController)
        vd.setVideoURI(uri)
        vd.requestFocus()
        vd.start()

        val wbid = "m_NBB4RFtWY"
        val wd:WebView = findViewById(R.id.webView)
        val webSettings:WebSettings = wd.settings
        webSettings.javaScriptEnabled = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        wd.loadUrl("https://www.youtube.com/embed/$wbid")
    }
}