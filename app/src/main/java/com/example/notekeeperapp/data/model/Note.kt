package com.example.notekeeperapp.data.model

//@Entity(tableName = "notes")
data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val date: String
) {
}