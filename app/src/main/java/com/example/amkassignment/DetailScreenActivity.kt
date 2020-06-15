package com.example.amkassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View.GONE
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.amkassignment.viewmodel.DetailActivityViewModel
import kotlinx.android.synthetic.main.activity_edit_delete.*
import kotlinx.android.synthetic.main.add_note_layout.view.*

class DetailScreenActivity : AppCompatActivity() {

    private lateinit var viewmodel: DetailActivityViewModel
    var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_delete)
        viewmodel = ViewModelProvider(this).get(DetailActivityViewModel::class.java)


        if (intent.hasExtra("Note")) {
            txtdetails.text = intent.getStringExtra("Note")
            btnshowall.text = "Show All Note"
        }
        if (intent.hasExtra("nid")) {
            id = intent.getIntExtra("nid", 0)
        }


        btnEdit.setOnClickListener {
            if (intent.hasExtra("Note")) {
                alertDialog()
            }
        }
        btnDelete.setOnClickListener {
            viewmodel.deleteNote(id)
            relative_one.visibility = GONE
        }

        viewmodel.list.observe(this, Observer {
            if (it != null) {
                txtdetails.text = it.note
            } else {
                finish()
            }
        })

        btnshowall.setOnClickListener {
            showBottomSheetDialogFragment()
        }


    }
    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

    private fun alertDialog() {

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_note_layout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Update Note")
          val mAlertDialog = mBuilder.show()
          mDialogView.btnAdd.setOnClickListener {
            val name = mDialogView.edtNote.text.toString()
            if (name!!.isNotEmpty()) {
                viewmodel.updateNote(id, name)
            }
            Log.d("AlertDialog", "AlertDialogNote ${name}")
            Toast.makeText(this, "AlertDialogNote ${name}", Toast.LENGTH_LONG)
            mAlertDialog.dismiss()

        }
    }
}
