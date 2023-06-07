package com.example.notepade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notepade.databinding.ActivityAddNoteBinding
import java.util.*

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddNoteBinding
    private lateinit var  type:String
    private  var noteid:Int=-1
    private lateinit var noteTitle:String
    private lateinit var noteDesc:String
    private lateinit var appDataBase: AppDataBase
    private lateinit var notesDao: NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)



        type= intent.getStringExtra("type").toString()
        if (type.equals("update")){
            supportActionBar?.setTitle("Update Note")
            noteid=intent.getIntExtra("id",-1)
            noteTitle=intent.getStringExtra("title").toString()
            noteDesc=intent.getStringExtra("desc").toString()

            binding.titleEd.setText(noteTitle)
            binding.descriptonEd.setText(noteDesc)

        }else{
            supportActionBar?.setTitle("Add Note")

        }

        appDataBase=AppDataBase.getDataBase(this)
        notesDao=appDataBase.getNotesDao()

        binding.saveBtn.setOnClickListener {
            val title= binding.titleEd.text.toString()
            val desc=binding.descriptonEd.text.toString()
            if(type.equals("Add")){
                val model=  NoteTable(0,title,desc, Calendar.getInstance().timeInMillis)
                notesDao.insertNotes(model)
            }else{
                val model=  NoteTable(0,title,desc, Calendar.getInstance().timeInMillis)
                notesDao.updateNote(model)
            }

            finish()
        }





    }
}