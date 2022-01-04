package com.example.androidmviexample.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidmviexample.domain.model.Note
import com.example.androidmviexample.storage.entity.NoteEntity

@Dao
abstract class NoteDao {
    suspend fun insertDomainNote(note: Note) {
        insertNote(
            NoteEntity(
                noteContent = note.noteContent,
                noteTitle = note.noteTitle
            )
        )
    }

    @Insert
    abstract suspend fun insertNote(note: NoteEntity): Long

    @Query("SELECT * FROM notes")
    abstract suspend fun getAllNotes(): List<NoteEntity>
}
