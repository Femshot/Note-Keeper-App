package com.example.notekeeperapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notekeeperapp.NoteModel
import com.example.notekeeperapp.data.model.Note

@Composable
fun NoteListScreen(
    noteModel: NoteModel = viewModel()
) {
    val notes = noteModel.notes
//    if (notes.isNotEmpty()) {
//        Log.d("NoteListScreen", "Notes: ${notes}")
//    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(notes) { note ->
            NoteItem(note)
//            Log.d("NoteListScreen", "Note: ${note.title}")
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = note.id.toString())
            Text(text = note.title)
            Text(text = note.date)
        }
        Text(text = note.content)
    }
}
