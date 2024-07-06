package com.example.noteup.ui.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int?,
    var title:String,
    var subTitle:String,
    var note:String,
    var date:String,
    var priority:String
) : Parcelable
