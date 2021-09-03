package com.example.pr_4_19012011094

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText: TextInputEditText = findViewById(R.id.editText)
        val buttonCall: Button = findViewById(R.id.button_call)
        val buttonUrl: Button = findViewById(R.id.button_url)
        val buttonContact: Button = findViewById(R.id.button_contact)
        val buttonCalllog: Button = findViewById(R.id.button_call_log)
        val buttonGallery: Button = findViewById(R.id.button_gallery)
        val buttonAlarm: Button = findViewById(R.id.button_alarm)
        val buttonCamera: Button = findViewById(R.id.button_camera)

        buttonCall.setOnClickListener(View.OnClickListener {
            Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:"+editText.getText())).apply {
                startActivity(this)
            }
        })

        buttonUrl.setOnClickListener(View.OnClickListener {
            Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://"+editText.getText())).apply {
                startActivity(this)
            }
        })

        buttonContact.setOnClickListener(View.OnClickListener {
            Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI).setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE).apply {
                startActivity(this)
            }
        })

        buttonCalllog.setOnClickListener(View.OnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply {
                startActivity(this)
            }
        })

        buttonGallery.setOnClickListener(View.OnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").apply {
                startActivity(this)
            }
        })

        buttonAlarm.setOnClickListener(View.OnClickListener {
            Intent(AlarmClock.ACTION_SET_ALARM).apply {
                startActivity(this)
            }
        })

        buttonCamera.setOnClickListener(View.OnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                startActivity(this)
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}