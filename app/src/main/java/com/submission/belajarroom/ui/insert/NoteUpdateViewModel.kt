package com.submission.belajarroom.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.submission.belajarroom.database.Note
import com.submission.belajarroom.respository.NoteRepository

class NoteUpdateViewModel(application: Application): ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}