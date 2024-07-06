package com.example.noteup.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
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

    fun getAllNotes():LiveData<List<Note>> =NoteRepo.getAllNotes()

    fun updateNote(note:Note){
        viewModelScope.launch {
            NoteRepo.updateNote(note)
        }
    }
    fun getHighNotes() :LiveData<List<Note>> = NoteRepo.getHighNotes()


    fun getMediumNotes() :LiveData<List<Note>> = NoteRepo.getMediumNotes()


    fun getLowNotes() :LiveData<List<Note>> = NoteRepo.getLowNotes()


}