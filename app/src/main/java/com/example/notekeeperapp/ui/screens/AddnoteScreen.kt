package com.example.notekeeperapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notekeeperapp.NoteModel
import com.example.notekeeperapp.data.model.Note

@Composable
fun AddNoteScreen(
    noteModel: NoteModel = viewModel(),
    onNavigate: () -> Unit
){
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var id by remember { mutableStateOf(0) }
    var date by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        InputField(
            value = title,
            onChange = { title = it },
            label = "Title"
        )
        Spacer(Modifier.height(12.dp))
        InputField(
            value = content,
            onChange = { content = it },
            label = "Content"
        )
        Spacer(Modifier.height(12.dp))
        InputField(
            value = date,
            onChange = { date = it },
            label = "Date"
        )
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = {
                id++
                val note = Note(
                    id = id,
                    title = title,
                    content = content,
                    date = date
                )
                noteModel.addNote(note)
                title = ""
                content = ""
                date = ""
            }
        ) {
            Text("Add Note")
        }
        Spacer(Modifier.height(52.dp))
        Button(
            onClick = {
                onNavigate()
            }
        ) {
            Text("View All Notes")
        }
    }
}

@Composable
fun InputField(
    value: String,
    onChange: (String) -> Unit,
    label: String
) {
    TextField(
        value = value,
        onValueChange = onChange,
        label = {
            Text(text = label)
        },
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun AddNoteScreenPreview() {
    AddNoteScreen(
        onNavigate = {}
    )
}