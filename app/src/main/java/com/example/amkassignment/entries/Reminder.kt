package com.example.amkassignment.entries

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Reminder constructor(message: String,reminder:String){
    @PrimaryKey(autoGenerate = true)
    var rid: Int = 0
    @ColumnInfo(name = "message")
    var message: String? = message
    @ColumnInfo(name = "reminder")
    var reminder: String? = reminder


}
