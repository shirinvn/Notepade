package com.example.notepade

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteTable (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val description:String,
    val dateAdded:Long
)