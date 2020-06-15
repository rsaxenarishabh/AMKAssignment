package com.example.amkassignment

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.amkassignment.adapter.NoteAdapter
import com.example.amkassignment.adapter.ReminderAdapter
import com.example.amkassignment.viewmodel.NoteViewModel
import com.example.amkassignment.viewmodel.ReminderViewModel
import kotlinx.android.synthetic.main.activity_add_note_list.*
import kotlinx.android.synthetic.main.activity_add_reminder_list.*
import kotlinx.android.synthetic.main.add_note_layout.view.*
import kotlinx.android.synthetic.main.add_reminder_layout.*
import kotlinx.android.synthetic.main.add_reminder_layout.view.*
import kotlinx.android.synthetic.main.add_reminder_layout.view.txtTimePicker
import java.text.SimpleDateFormat
import java.util.*

class AddReminderListActivity : AppCompatActivity() {


    private lateinit var viewmodel: ReminderViewModel
    private lateinit var adapter: ReminderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reminder_list)
        viewmodel = ViewModelProvider(this).get(ReminderViewModel::class.java)

        viewmodel.getReminder()
        viewmodel.reminderList.observe(this, androidx.lifecycle.Observer {
            Log.d("ReminderList", "ReminderList ${it}")
            if (it != null) {
                adapter.setLocationlist(it)
                txtNoitemReminder.visibility = View.GONE
                Toast.makeText(this, "Success", Toast.LENGTH_LONG)
                Log.d("ReminderList", "ReminderList ${it}")
            } else {
                txtNoitemReminder.visibility = View.VISIBLE
            }

        })
        adapter = ReminderAdapter(this)
        recyclerAddreminder.adapter = adapter


        addreminder.setOnClickListener {
            alertdialog()
        }
    }

    override fun onResume() {
        super.onResume()
        viewmodel.getReminder()
    }

    private fun alertdialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_reminder_layout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Add Reminder")
        val mAlertDialog = mBuilder.show()
        mDialogView.btnaddremider.setOnClickListener {
            val message = mDialogView.edtReminder.text.toString()
            val reminder = mDialogView.txtTimePicker.text.toString()
            if (message!!.isNotEmpty() && reminder!!.isNotEmpty()) {
               viewmodel.addReminder(message,reminder)
            }
            Log.d("AlertDialog", "AlertDialogNote ${message}")
            Toast.makeText(this, "AlertDialogNote ${reminder}", Toast.LENGTH_LONG)
            mAlertDialog.dismiss()
        }


        mDialogView.txtTimePicker.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                mDialogView.txtTimePicker.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

    }
}