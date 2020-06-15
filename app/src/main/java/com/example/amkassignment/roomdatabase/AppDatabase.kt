package com.example.amkassignment.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.amkassignment.dao.notesDao
import com.example.amkassignment.dao.reminderDao
import com.example.amkassignment.entries.Notes
import com.example.amkassignment.entries.Reminder


/**
 * Created by axier on 7/2/18.
 */

@Database(entities = [(Notes::class), (Reminder::class)], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {


    abstract fun noteDao() : notesDao
    abstract fun reminderDao(): reminderDao
    companion object {
        private var sInstance: AppDatabase? = null
        /**
         * Gets the singleton instance of SampleDatabase.
         *
         * @param context The context.
         * @return The singleton instance of SampleDatabase.
         */
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "example")
                        .fallbackToDestructiveMigration().allowMainThreadQueries()
                        .build()
            }
            return sInstance!!
        }
    }

}
