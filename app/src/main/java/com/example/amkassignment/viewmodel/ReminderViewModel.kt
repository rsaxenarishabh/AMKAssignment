package com.example.amkassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.amkassignment.entries.Reminder
import com.example.amkassignment.repository.ReminderRepository

class ReminderViewModel (application: Application) : AndroidViewModel(application){

    val repository = ReminderRepository(application)
    val reminderList : LiveData<List<Reminder>>
    init {
        this.reminderList=repository.reminderList
    }

    fun getReminder(){
        repository.getReminder()
    }
    fun addReminder(message:String,reminder:String){
        repository.addReminder(message,reminder)

    }
}