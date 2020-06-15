package com.example.amkassignment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.amkassignment.adapter.BottomSheetNoteAdapter
import com.example.amkassignment.adapter.BottomSheetReminderAdapter
import com.example.amkassignment.roomdatabase.AppDatabase
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet_reminder.*


class BottomSheetReminderFragment : BottomSheetDialogFragment() {

    private var fragmentView: View? = null
    private lateinit var adapter: BottomSheetReminderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_bottom_sheet_reminder, container, false)
        return fragmentView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = AppDatabase.getInstance(context!!.applicationContext).reminderDao().allReminder
        adapter = BottomSheetReminderAdapter(context!!.applicationContext)
        Log.d("BottomSheetFragment", "Reminder Data is ${data}")
        if (data != null) {
            adapter.setLocationlist(data)
            recyclerviewreminder!!.adapter = adapter
        }



    }


}