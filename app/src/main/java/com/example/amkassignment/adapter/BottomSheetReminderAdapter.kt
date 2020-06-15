package com.example.amkassignment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amkassignment.DetailActivityForReminder
import com.example.amkassignment.R
import com.example.amkassignment.entries.Reminder
import kotlinx.android.synthetic.main.bottom_sheet_reminder_data.view.*
import kotlinx.android.synthetic.main.item_reminder_layout.view.*

class BottomSheetReminderAdapter( private val context: Context) :
    RecyclerView.Adapter<BottomSheetReminderAdapter.ViewHolder>() {
    private var list: List<Reminder> = ArrayList()

    fun setLocationlist(list: List<Reminder>){
        this.list=list
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val message = view.textReminder!!
        val time = view.texttime!!


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.bottom_sheet_reminder_data, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.message.text = list[position].message
        holder.time.text = list[position].reminder


    }


}