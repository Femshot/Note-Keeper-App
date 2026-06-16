package com.example.notekeeperapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notekeeperapp.data.model.Note
import kotlinx.coroutines.flow.Flow

//Second step:
//This is the data access object for the table
//It manages the process of accessing the table data
@Dao
interface NoteDao{
    //abstraction of sql queries through methods that are automatically implemented

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(note: Note)

    @Delete
    suspend fun delete(note: Note)
    
    @Query("SELECT * FROM notes_table ORDER BY timestamp DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes_table WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?
}