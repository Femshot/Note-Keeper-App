package com.example.notekeeperapp.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notekeeperapp.NoteViewModel
import com.example.notekeeperapp.data.model.Note

@Composable
fun NoteListScreen(
    noteModel: NoteViewModel,
    onAddNote: () -> Unit,
    onNoteClick: (Int) -> Unit
) {
    val notes = noteModel.notes.collectAsState(initial = emptyList())
//    if (notes.isNotEmpty()) {
//        Log.d("NoteListScreen", "Notes: ${notes}")
//    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNote) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize()) {
            items(notes.value) { note ->
                NoteItem(note = note, onClick = { onNoteClick(note.id) })
            }
        }
    }

}


@Composable
fun NoteItem(note: Note, onClick: () -> Unit) {
    Card (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable{onClick()}
    )
    {
        Column{
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = note.id.toString())
                Text(text = note.title)

            }
            Text(text = note.content)
        }
    }

}
