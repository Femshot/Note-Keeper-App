package com.example.notekeeperapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notekeeperapp.data.model.Note
import com.example.notekeeperapp.data.respository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel() {
    val notes = noteRepository.allNotes
    private val _selectedNote = MutableStateFlow <Note?>(null)
    val selectedNote: MutableStateFlow<Note?> = _selectedNote

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.insert(note)
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.delete(note)
        }
    }

    fun getNoteById(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            _selectedNote.value = noteRepository.getNoteById(id)
        }
    }
}