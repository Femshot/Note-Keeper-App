package com.example.notekeeperapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notekeeperapp.data.model.Note
import com.example.notekeeperapp.data.respository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel() {
    val notes = noteRepository.allNotes
    private val _selectedNote = MutableStateFlow <Note?>(null)
    val selectedNote: MutableStateFlow<Note?> = _selectedNote

    fun addNote(note: Note) {
        viewModelScope.launch{
            noteRepository.insert(note)

        }
//        Log.d("notelist", " curent list is ${notes}")
    }
    fun deleteNote(note: Note){
        viewModelScope.launch {
            noteRepository.delete(note)

        }
    }
    fun getNotebyid(id: Int){
        viewModelScope.launch {
            _selectedNote.value = noteRepository.getNoteById(id)

        }
    }
}