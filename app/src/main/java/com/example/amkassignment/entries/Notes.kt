package com.example.amkassignment.entries

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Notes constructor(note: String) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
    @ColumnInfo(name = "note")
    var note: String? = note


}