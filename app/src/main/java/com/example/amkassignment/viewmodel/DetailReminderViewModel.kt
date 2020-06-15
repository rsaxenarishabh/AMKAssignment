package com.example.amkassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.amkassignment.entries.Reminder
import com.example.amkassignment.repository.DetailedRepositoryforReminder

class DetailReminderViewModel(application: Application) : AndroidViewModel(application) {
    val repository = DetailedRepositoryforReminder(application)
    val list: LiveData<Reminder>

    init {
        this.list = repository.list
    }

    fun deleteReminder(id: Int) {
        repository.deleteReminder(id)
    }

    fun updateReminder(id: Int, message: String, reminder: String) {
        repository.updateReminder(id, message, reminder)
    }


}