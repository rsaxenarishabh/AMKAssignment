package com.example.amkassignment.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.amkassignment.entries.Reminder
import com.example.amkassignment.roomdatabase.AppDatabase

class ReminderRepository(val application: Application) {

    val reminderList= MutableLiveData<List<Reminder>>()


    fun getReminder() {
      val reminder=  AppDatabase.getInstance(application).reminderDao().allReminder
        reminderList.value=reminder
        Log.d("ReminderRepository","notes ${reminder}")
    }



    fun addReminder(message: String, reminder: String) {
        val remi = Reminder(message, reminder)
        AppDatabase.getInstance(application).reminderDao().insertReminder(remi)
        AppDatabase.getInstance(application).reminderDao().allReminder.forEach {
            Log.d("ReminderRepository", "Message ${it.message}")
            Log.d("ReminderRepository", "Reminder ${it.reminder}")
        }
        getReminder()


    }

}