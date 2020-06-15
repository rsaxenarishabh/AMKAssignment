package com.example.amkassignment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amkassignment.DetailScreenActivity
import com.example.amkassignment.R
import com.example.amkassignment.entries.Notes
import kotlinx.android.synthetic.main.item_recycler.view.*

class NoteAdapter( private val context: Context) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private var list: List<Notes> = ArrayList()

    fun setLocationlist(list: List<Notes>){
        this.list=list
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.textNote!!
        val rootlavel = view.relativenote!!


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].note

        holder.rootlavel.setOnClickListener {
            val intent = Intent(context, DetailScreenActivity::class.java)
            intent.putExtra("Note", list[position].note)
            intent.putExtra("nid", list[position].uid)
            context.startActivity(intent)

        }

    }
}