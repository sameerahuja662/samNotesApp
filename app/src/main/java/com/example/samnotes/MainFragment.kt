package com.example.samnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samnotes.adapter.NotesAdapter
import com.example.samnotes.model.Note
import kotlinx.android.synthetic.main.fragment_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        fabBtnCreateNote.setOnClickListener(this)

        val recyclerView: RecyclerView = recycler_view

        //adding a layout manager
        recyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        //Creating a Notes List as a data store.

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")

        val currentDate:String = sdf.format(Date())

        val notesList = mutableListOf<Note>()

        notesList.add(Note("First Note","First Desc" ,currentDate))
        notesList.add(Note("Second Note","Second Desc", currentDate ))
        notesList.add(Note("Third Note","Third Desc",currentDate ))

        //Creating a custom adapter
        val notesAdapter = NotesAdapter(notesList)
        //Assigning the adapter
        recyclerView.adapter = notesAdapter

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.fabBtnCreateNote -> {navController.navigate(R.id.action_mainFragment_to_addNoteFragment)}
        }
    }
}
