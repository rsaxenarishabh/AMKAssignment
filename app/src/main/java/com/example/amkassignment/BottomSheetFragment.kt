package com.example.amkassignment

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.amkassignment.adapter.BottomSheetNoteAdapter
import com.example.amkassignment.adapter.NoteAdapter
import com.example.amkassignment.roomdatabase.AppDatabase
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_add_note_list.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomSheetFragment : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    private var fragmentView: View? = null
    private lateinit var adapter: BottomSheetNoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = AppDatabase.getInstance(context!!.applicationContext).noteDao().allNotes
        adapter = BottomSheetNoteAdapter(context!!.applicationContext)

        if (data != null) {
            adapter.setLocationlist(data)
            recyclerviewsheet!!.adapter = adapter
        }
        Log.d("BottomSheetFragment", "Data is ${data}")
    }
}