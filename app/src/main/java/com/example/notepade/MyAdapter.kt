package com.example.notepade

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notepade.databinding.ViewBinding

class MyAdapter(val context: Context, val list: List<NoteTable>, val listener:MyInterface ): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder (binding:ViewBinding): RecyclerView.ViewHolder(binding.root) {
        val title= binding.titleTxt
        val descrip=binding.descTxt
        val delete = binding.deleteicon

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return MyViewHolder(ViewBinding.bind(view))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model=list.get(position)



        holder.title.text=model.title
        holder.descrip.text=model.description

        holder.itemView.setOnClickListener {

            context.startActivity(
                Intent(context, AddNoteActivity::class.java).putExtra("type","update")
                .putExtra("id",model.id)
                .putExtra("title",model.title)
                .putExtra("desc",model.description)

            )

        }
        holder.delete.setOnClickListener{
            listener.onClick(model.id)
        }

    }

    override fun getItemCount(): Int {

        return list.size
    }
}