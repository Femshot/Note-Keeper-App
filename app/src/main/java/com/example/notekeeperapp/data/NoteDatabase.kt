package com.example.notekeeperapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notekeeperapp.data.model.Note

//Creates sql database that holds table or related tables for project
@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            return INSTANCE ?: synchronized(lock = this) {
                    val instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        klass = NoteDatabase::class.java,
                        name = "note_database"
                    ).build()

                    INSTANCE = instance
                    return instance
                }
        }
     }
}