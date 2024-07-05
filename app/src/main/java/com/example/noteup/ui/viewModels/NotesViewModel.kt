package com.example.noteup.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteup.ui.dao.NotesDao
import com.example.noteup.ui.db.NotesDatabase
import com.example.noteup.ui.models.Note
import com.example.noteup.ui.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(application: Application):AndroidViewModel(application) {


    val NoteRepo:NotesRepository

    init {
        val dao=NotesDatabase.getDatabaseInstance(application).getNotesDao()
        NoteRepo= NotesRepository(dao)
    }

    fun addNotes(notes: Note) {
        viewModelScope.launch {
            NoteRepo.createNote(notes)
        }
    }

}