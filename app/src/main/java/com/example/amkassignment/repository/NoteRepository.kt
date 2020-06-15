package com.example.amkassignment.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.amkassignment.entries.Notes
import com.example.amkassignment.roomdatabase.AppDatabase

class NoteRepository(val application: Application) {


    val noteList = MutableLiveData<List<Notes>>()


    fun getNote() {
        val notes=AppDatabase.getInstance(application).noteDao().allNotes
        noteList.value=notes
       Log.d("NoteRepository","notes ${notes}")


    }

    fun addnote(note: String) {
        val notes = Notes(note)
        AppDatabase.getInstance(application).noteDao().insertNote(notes)
        getNote()
        AppDatabase.getInstance(application).noteDao().allNotes.forEach {
            Log.d("NoteRepository", "Note ${it.note}")
            Log.d("NoteRepository", "id ${it.uid}")
        }

    }

}


