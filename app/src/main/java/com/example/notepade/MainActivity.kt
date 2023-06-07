package com.example.notepade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notepade.databinding.ActivityMainBinding

class MainActivity :MyInterface, AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding
    private lateinit var appDataBase: AppDataBase
    private lateinit var notesDao: NotesDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle (" My Notes")
        appDataBase=AppDataBase.getDataBase(this)
        notesDao=appDataBase.getNotesDao()


        binding.floatBtn.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java).putExtra("type","Add"))
        }

        loadAllNotes()

    }

    private fun loadAllNotes() {
        val items= notesDao.getAllNotes().reversed()
        binding.recycler.adapter=MyAdapter(this,items,this)
        binding.recycler.layoutManager= LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()
        loadAllNotes()
    }

    override fun onClick(id: Int) {
        notesDao.deleteNote(id)
        loadAllNotes()
    }

}