package com.example.notepade

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {

    @Insert
    fun insertNotes(noteTable: NoteTable)


    @Update
    fun updateNote(noteTable: NoteTable)


    @Query("SELECT * from NoteTable ")
    fun getAllNotes():List<NoteTable>
    @Query("Delete from NoteTable where id=:id")
    fun deleteNote(id :Int)
}