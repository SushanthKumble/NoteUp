package com.example.noteup.ui.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteup.ui.dao.NotesDao
import com.example.noteup.ui.db.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext  app:Context) =
        Room.databaseBuilder(
            app,
            NotesDatabase::class.java,
            "notes_database"
        ).build()

    @Provides
    @Singleton
    fun providesDao(db:NotesDatabase):NotesDao{
        return  db.getNotesDao()
    }


}