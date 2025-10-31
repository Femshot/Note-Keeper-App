package com.example.notekeeperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.Room
import com.example.notekeeperapp.data.NoteDatabase
import com.example.notekeeperapp.data.respository.NoteRepository
import com.example.notekeeperapp.ui.screens.AddNoteScreen
import com.example.notekeeperapp.ui.screens.NoteListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create Room database instance
        val db = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "note_database"
        ).build()

        // Create repository instance
        val repository = NoteRepository(db.noteDao())

        setContent {
            val factory = viewModelFactory {
                initializer {
                    NoteViewModel(repository)
                }
            }
            val viewModel: NoteViewModel = viewModel(factory = factory)



            // 3️⃣ Simple navigation using states
            var showAddScreen by remember { mutableStateOf(false) }

            if (showAddScreen)
                AddNoteScreen(viewModel) { showAddScreen = false }
            else
                NoteListScreen(viewModel, onAddNote = { showAddScreen = true }, onNoteClick = {})
        }
    }
}

