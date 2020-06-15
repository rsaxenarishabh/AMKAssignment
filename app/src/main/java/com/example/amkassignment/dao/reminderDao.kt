package com.example.amkassignment.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.amkassignment.entries.Notes
import com.example.amkassignment.entries.Reminder

@Dao
interface reminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReminder(reminder : Reminder)


   @get:Query("Select * from Reminder")
    val allReminder: List<Reminder>



    @Query("UPDATE Reminder SET message=:message,reminder=:reminder WHERE rid=:id")
    fun UpdateColumnById(message:String?,reminder: String?, id: Int)


    @Query("SELECT * FROM Reminder WHERE rid IN (:rid)")
    fun getUsers( rid: Int): Reminder

    @Query("DELETE FROM Reminder WHERE rid = :id")
    fun deleteByUserId(id: Int)

}