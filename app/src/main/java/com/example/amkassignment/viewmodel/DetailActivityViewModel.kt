package com.example.amkassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.amkassignment.entries.Notes
import com.example.amkassignment.repository.DetailedActivityRepository

class DetailActivityViewModel(application: Application) : AndroidViewModel(application) {
    val repository = DetailedActivityRepository(application)
    val list: LiveData<Notes>
    init {
        this.list = repository.list
    }

    fun updateNote(id: Int, name: String) {
        repository.updatenote(id, name)
    }

    fun deleteNote(id: Int) {
        repository.deleteNote(id)
    }


}