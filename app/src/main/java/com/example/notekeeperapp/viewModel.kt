package com.example.notekeeperapp

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.notekeeperapp.data.model.Note

class NoteModel: ViewModel() {
    val notes = mutableListOf<Note>()

    fun addNote(note: Note) {
        notes.add(note)
//        Log.d("notelist", " curent list is ${notes}")
    }
}