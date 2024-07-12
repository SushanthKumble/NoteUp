package com.example.noteup.ui.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteup.ui.dao.NotesDao
import com.example.noteup.ui.models.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
 abstract class NotesDatabase : RoomDatabase() {

   abstract fun getNotesDao(): NotesDao


}
