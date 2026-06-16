package com.example.notekeeperapp.data.respository

import android.content.Context
import com.example.notekeeperapp.data.NoteDao
import com.example.notekeeperapp.data.NoteDatabase


class AppContainer(val context: Context) {

    private val noteDao: NoteDao by lazy {
        NoteDatabase.getDatabase(context).noteDao()
    }

    val noteRepository: NoteRepository by lazy {
        NoteRepository(noteDao)
    }
}