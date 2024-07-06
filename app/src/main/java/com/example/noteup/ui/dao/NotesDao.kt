package com.example.noteup.ui.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteup.ui.models.Note

@Dao
interface NotesDao {

    // Function to insert a note
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)


    //function to get the notes with high priority

    @Query("SELECT * FROM Notes WHERE priority=3")
     fun getHighNotes() :LiveData<List<Note>>
    @Query("SELECT * FROM Notes WHERE priority=2")
     fun getMediumNotes() :LiveData<List<Note>>

    @Query("SELECT * FROM Notes WHERE priority=1")
     fun getLowNotes() :LiveData<List<Note>>


    // Function to get all the notes
    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Note>>

    // Function to delete a note
    @Query("DELETE FROM Notes WHERE id = :id")
    suspend fun deleteNote(id: Int?)

    // Function to update a note
    @Update
    suspend fun updateNote(note: Note)
}
