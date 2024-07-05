package com.example.noteup.ui.repository


import com.example.noteup.ui.dao.NotesDao
import com.example.noteup.ui.models.Note

class NotesRepository(val notedao:NotesDao) {

    //create Note
    suspend fun createNote(note: Note){
        notedao.insertNote(note)
    }

    //getallnote

    fun getAllNotes(){
        notedao.getNotes()
    }

    //update notes
    suspend fun updateNote(note:Note){
        notedao.updateNote(note)
    }

    //delete note

    suspend fun deleteNote(id:Int){
        notedao.deleteNote(id)
    }



}