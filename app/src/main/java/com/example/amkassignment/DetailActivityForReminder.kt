package com.example.amkassignment

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.amkassignment.viewmodel.DetailActivityViewModel
import com.example.amkassignment.viewmodel.DetailReminderViewModel
import kotlinx.android.synthetic.main.activity_detail_for_reminder.*
import kotlinx.android.synthetic.main.activity_edit_delete.*
import kotlinx.android.synthetic.main.add_reminder_layout.view.*
import kotlinx.android.synthetic.main.item_reminder_layout.*
import java.text.SimpleDateFormat
import java.util.*

class DetailActivityForReminder : AppCompatActivity() {


    private lateinit var viewmodel: DetailReminderViewModel
    var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_for_reminder)
        viewmodel = ViewModelProvider(this).get(DetailReminderViewModel::class.java)


        if (intent.hasExtra("Reminder")) {
            txtTime.text = intent.getStringExtra("Reminder")

        }


        if (intent.hasExtra("Message")) {
            txtReminderdetails.text = intent.getStringExtra("Message")

        }
        if (intent.hasExtra("rid")) {
            id = intent.getIntExtra("rid", 0)

        }


        btnReminderEdit.setOnClickListener {
            alertdialog()

        }

        btnReminderDelete.setOnClickListener {
            viewmodel.deleteReminder(id)
            relative_reminder.visibility = GONE

        }

        viewmodel.list.observe(this, androidx.lifecycle.Observer {
            if (it != null) {
                txtTime.text = it.reminder
                txtReminderdetails.text = it.message
            }
        })

        btnshowallreminder.setOnClickListener {
            showBottomSheetDialogFragment()

        }


    }

    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetReminderFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
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
                viewmodel.updateReminder(id, message, reminder)
            }
            Log.d("AlertDialogUpdate", "AlertDialogUpdate ${message}")
            Toast.makeText(this, "AlertDialogUpdate ${reminder}", Toast.LENGTH_LONG)
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