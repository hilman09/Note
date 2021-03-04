package com.submission.belajarroom.respository

import android.app.Application
import androidx.lifecycle.LiveData
import com.submission.belajarroom.database.Note
import com.submission.belajarroom.database.NoteDAO
import com.submission.belajarroom.database.NoteROOMDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository (application: Application){
   private val mNotesDao: NoteDAO
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteROOMDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }
    fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()

    fun insert(note: Note) {
        executorService.execute { mNotesDao.insert(note) }
    }

    fun delete(note: Note) {
        executorService.execute { mNotesDao.delete(note) }
    }

    fun update(note: Note) {
        executorService.execute { mNotesDao.update(note) }
    }
}