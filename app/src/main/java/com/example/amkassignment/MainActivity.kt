package com.example.amkassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAddnotes.setOnClickListener {
            val intent=Intent(this,AddNoteListActivity::class.java)
            startActivity(intent)
            finish()
        }


        btnAddReminder.setOnClickListener {
            val intent=Intent(this,AddReminderListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
