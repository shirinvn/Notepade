package com.example.notepade

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [NoteTable::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getNotesDao():NotesDao
    companion object{
        private var  INSTANCE:AppDataBase?= null
        fun getDataBase(context: Context):AppDataBase{
            synchronized(this){
                if (INSTANCE == null){
                    INSTANCE= Room.databaseBuilder(context,
                        AppDataBase::class.java,"app database")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }

    }
}