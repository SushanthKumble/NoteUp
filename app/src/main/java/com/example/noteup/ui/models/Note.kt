package com.example.noteup.ui.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int?,
    var title:String,
    var subTitle:String,
    var note:String,
    var date:String,
    var priority:String
)
