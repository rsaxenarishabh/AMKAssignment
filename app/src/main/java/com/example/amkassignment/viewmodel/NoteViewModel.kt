package com.example.amkassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.amkassignment.entries.Notes
import com.example.amkassignment.repository.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val repository = NoteRepository(application)
    val notelist: LiveData<List<Notes>>

    init {
        this.notelist = repository.noteList
    }


    fun addnote(note: String) {
        repository.addnote(note)
    }

    fun getNote() {
        repository.getNote()
    }


}