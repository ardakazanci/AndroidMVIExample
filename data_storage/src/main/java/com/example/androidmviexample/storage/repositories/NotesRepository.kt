package com.example.androidmviexample.storage.repositories

import com.example.androidmviexample.domain.model.Note
import com.example.androidmviexample.domain.repositories.NoteRepository
import com.example.androidmviexample.storage.dao.NoteDao

class NotesRepository(
    private val noteDao: NoteDao
) : NoteRepository {
    override suspend fun getNotes(): List<Note> {
        return noteDao.getAllNotes().map { Note(it.noteId, it.noteTitle,it.noteContent) }
    }

    override suspend fun saveNote(note: Note) {
        noteDao.insertDomainNote(note)
    }
}
