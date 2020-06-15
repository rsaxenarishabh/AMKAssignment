package com.example.amkassignment.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.amkassignment.entries.Notes

@Dao
interface notesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note : Notes)


    @get:Query("Select * from Notes")
    val allNotes: List<Notes>

    @Query("UPDATE Notes SET note=:note WHERE uid=:id")
   fun UpdateColumnById(note: String?, id: Int)


    @Query("SELECT * FROM Notes WHERE uid IN (:uid)")
    fun getUsers( uid: Int): Notes

    @Query("DELETE FROM Notes WHERE uid = :userId")
    fun deleteByUserId(userId: Int)



//    @Delete
//    fun delete(id:Int)



}