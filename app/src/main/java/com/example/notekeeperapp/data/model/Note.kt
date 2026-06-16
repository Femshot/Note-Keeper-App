package com.example.notekeeperapp.data.model

//import androidx.datastore.preferences.protobuf.Timestamp
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//First step:
//Create an entity, which is a table for the database
@Entity(tableName = "notes_table")
data class Note(
    //properties in class serve as columns for table schema
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "note_title")
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)