package com.example.amkassignment.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.amkassignment.entries.Notes
import com.example.amkassignment.roomdatabase.AppDatabase

class DetailedActivityRepository(val application: Application) {

    val list = MutableLiveData<Notes>()
    fun updatedata(id:Int){
       val lis= AppDatabase.getInstance(application).noteDao().getUsers(id)
        list.value=lis
        Log.d("DetailedActivRepository", "UpdateData ${lis.note}")


    }
    fun updatenote(id: Int, name: String) {
        val num = AppDatabase.getInstance(application).noteDao().UpdateColumnById(name, id)
        Log.d("DetailedActivRepository", "Update ${num}")
        updatedata(id)
    }

    fun deleteNote(id: Int) {
        val num = AppDatabase.getInstance(application).noteDao().deleteByUserId(id)
        Log.d("DetailedActivity", "Delete Success ${num}")

    }
}