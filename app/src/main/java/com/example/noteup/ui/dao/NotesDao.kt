package com.example.noteup.ui.dao

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {

    //function to insert a notes
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    //function to get all the notes
    @Query("SELECT * FROM Notes")
     fun getNotes():LiveData<List<Note>>


     //function to delete note
     @Query("DELETE FROM Notes WHERE id=:id")
     suspend fun deleteNote(id:Int)


     //function to update note
    @Update
    suspend fun updateNote(note:Note)





}