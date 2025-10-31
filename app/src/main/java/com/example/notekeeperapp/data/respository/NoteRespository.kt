package com.example.notekeeperapp.data.respository

import com.example.notekeeperapp.data.NoteDao
import com.example.notekeeperapp.data.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao :NoteDao){
    val allNotes : Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.upsert(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

    suspend fun getNoteById(id: Int) : Note? {
        return noteDao.getNoteById(id)
    }
}

