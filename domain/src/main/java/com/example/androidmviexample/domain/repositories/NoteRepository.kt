package com.example.androidmviexample.domain.repositories

import com.example.androidmviexample.domain.model.Note

interface NoteRepository {
    suspend fun getNotes(): List<Note>
    suspend fun saveNote(note: Note)
}
