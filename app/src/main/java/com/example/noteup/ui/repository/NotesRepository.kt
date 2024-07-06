package com.example.noteup.ui.repository


import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.noteup.ui.dao.NotesDao
import com.example.noteup.ui.models.Note

class NotesRepository(val notedao:NotesDao) {

    //create Note
    suspend fun createNote(note: Note){
        notedao.insertNote(note)
    }

    //getallnote

    fun getAllNotes():LiveData<List<Note>> {
       return  notedao.getNotes()
    }

    //update notes
    suspend fun updateNote(note:Note){
        notedao.updateNote(note)
    }

    //delete note

    suspend fun deleteNote(id:Int?){
        notedao.deleteNote(id)
    }
     fun getHighNotes() :LiveData<List<Note>> =notedao.getHighNotes()

     fun getMediumNotes() :LiveData<List<Note>> = notedao.getMediumNotes()


     fun getLowNotes() :LiveData<List<Note>> = notedao.getLowNotes()





}