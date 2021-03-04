package com.submission.belajarroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteROOMDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDAO

    companion object{
        @Volatile
        private var INSTANCE: NoteROOMDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): NoteROOMDatabase {
            if (INSTANCE == null) {
                synchronized(NoteROOMDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                        NoteROOMDatabase::class.java,"note_database")
                        .build()
                    }
                }
            }
            return INSTANCE as NoteROOMDatabase
        }
    }

}