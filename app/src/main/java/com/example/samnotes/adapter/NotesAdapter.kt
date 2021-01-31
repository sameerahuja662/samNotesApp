package com.example.samnotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samnotes.R
import com.example.samnotes.model.Note
import kotlinx.android.synthetic.main.note_view_layout.view.*


class NotesAdapter (private val NotesList: List<Note>) : RecyclerView.Adapter<NotesAdapter.ViewHolder> () {


    //this method is returns the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.note_view_layout, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }

    override fun onBindViewHolder(viewHolder: NotesAdapter.ViewHolder, position: Int) {
        viewHolder.tittleView.text = NotesList[position].title
        viewHolder.descView.text = NotesList[position].desc
        viewHolder.dateTimeView.text = NotesList[position].dateTime
    }

    class ViewHolder(NoteView: View) : RecyclerView.ViewHolder(NoteView) {
        val tittleView: TextView
        val descView: TextView
        val dateTimeView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            tittleView = NoteView.tvTitle
            descView = NoteView.tvDesc
            dateTimeView = NoteView.tvDateTime

        }
    }



}