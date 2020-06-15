package com.example.amkassignment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amkassignment.DetailActivityForReminder
import com.example.amkassignment.DetailScreenActivity
import com.example.amkassignment.R
import com.example.amkassignment.entries.Notes
import com.example.amkassignment.entries.Reminder
import kotlinx.android.synthetic.main.item_recycler.view.*
import kotlinx.android.synthetic.main.item_reminder_layout.view.*

class ReminderAdapter( private val context: Context) :
    RecyclerView.Adapter<ReminderAdapter.ViewHolder>() {
    private var list: List<Reminder> = ArrayList()

    fun setLocationlist(list: List<Reminder>){
        this.list=list
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val message = view.textReminderMsg!!
        val time = view.textReminderTime!!
        val rootlavel = view.relativereminder!!


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_reminder_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.message.text = list[position].message
        holder.time.text = list[position].reminder

        holder.rootlavel.setOnClickListener {
            val intent = Intent(context, DetailActivityForReminder::class.java)
            intent.putExtra("Reminder", list[position].reminder)
            intent.putExtra("Message", list[position].message)
            intent.putExtra("rid", list[position].rid)

            context.startActivity(intent)

        }

    }


}