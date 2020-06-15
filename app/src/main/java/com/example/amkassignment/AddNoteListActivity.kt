package com.example.amkassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.amkassignment.adapter.NoteAdapter
import com.example.amkassignment.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_add_note_list.*
import kotlinx.android.synthetic.main.add_note_layout.view.*

class AddNoteListActivity : AppCompatActivity() {

    private lateinit var viewmodel: NoteViewModel
    private lateinit var adapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note_list)
        viewmodel = ViewModelProvider(this).get(NoteViewModel::class.java)

        viewmodel.getNote()
        viewmodel.notelist.observe(this, Observer {
            Log.d("AddNoteList", "AddNotelist ${it}")
            if (it != null) {
                adapter.setLocationlist(it)
                txtNoitem.visibility = GONE
                Toast.makeText(this, "Success", Toast.LENGTH_LONG)
                Log.d("AddNoteList", "AddNotelist ${it}")
            } else {
                txtNoitem.visibility = VISIBLE
            }
        })
        adapter = NoteAdapter(this)
        recyclerAddnote.adapter = adapter

        addnotes.setOnClickListener {
            alertdialog()
        }


    }

    override fun onResume() {
        super.onResume()
        viewmodel.getNote()
    }

    private fun alertdialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_note_layout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Add Note")
        val mAlertDialog = mBuilder.show()
        mDialogView.btnAdd.setOnClickListener {
            val name = mDialogView.edtNote.text.toString()
            if (name!!.isNotEmpty()) {
                viewmodel.addnote(name)
            }
            Log.d("AlertDialog", "AlertDialogNote ${name}")
            Toast.makeText(this, "AlertDialogNote ${name}", Toast.LENGTH_LONG)
            mAlertDialog.dismiss()
        }
    }
}

