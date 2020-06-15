package com.example.amkassignment.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.amkassignment.entries.Reminder
import com.example.amkassignment.roomdatabase.AppDatabase

class DetailedRepositoryforReminder(val application: Application) {

    val list = MutableLiveData<Reminder>()

    fun deleteReminder(id: Int) {

       val num= AppDatabase.getInstance(application).reminderDao().deleteByUserId(id)
        Log.d("DetailedActivity", "Delete Success ${num}")
    }


    fun updateReminder(id: Int, message: String, reminder: String) {
        val num = AppDatabase.getInstance(application).reminderDao()
            .UpdateColumnById(message, reminder, id)
        Log.d("DetailedActivReminderR", "Update ${num}")
        updatedata(id)
    }

    fun updatedata(id: Int) {
        val reminder = AppDatabase.getInstance(application).reminderDao().getUsers(id)
        list.value = reminder
    }

}