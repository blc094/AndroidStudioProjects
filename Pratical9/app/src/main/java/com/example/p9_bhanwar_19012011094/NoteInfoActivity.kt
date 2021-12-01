package com.example.p9_bhanwar_19012011094

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class NoteInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_info)

        val tvNoteTitle = findViewById<TextView>(R.id.tv_note_title)
        val tvNoteSubTitle = findViewById<TextView>(R.id.tv_note_sub_title)
        val tvNoteDescription = findViewById<TextView>(R.id.tv_note_description)

        val tvNoteTimeStamp = findViewById<TextView>(R.id.tv_note_time_stamp)
        val tvNoteReminderTime = findViewById<TextView>(R.id.tv_notes_reminder_time)

        val index = intent.getIntExtra("index", 0)

        tvNoteTitle.text = Notes.notesArray[index].title
        tvNoteSubTitle.text = Notes.notesArray[index].subTitle
        tvNoteDescription.text = Notes.notesArray[index].description
        val timeFormat = SimpleDateFormat("MMM, dd yyyy hh:mm:ss a", Locale.ENGLISH)
        tvNoteTimeStamp.text = timeFormat.format(Notes.notesArray[index].timeStamp)
        val time =
            "Reminder at " + timeFormat.format(Notes.notesArray[index].modifiedTime.timeInMillis)
        tvNoteReminderTime.text = time
    }

    override fun onBackPressed() {
        Intent(this, NotesActivity::class.java).apply {
            startActivity(this)
        }
        super.onBackPressed()
    }
}