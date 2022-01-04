package com.example.androidmviexample.domain.usecases

import com.example.androidmviexample.domain.model.Note
import com.example.androidmviexample.domain.repositories.NoteRepository

interface SaveNoteUseCase {
    suspend operator fun invoke(note: Note)
}

class SaveNoteUseCaseImpl(
    private val noteRepository: NoteRepository
) : SaveNoteUseCase {
    override suspend fun invoke(note: Note) {
        noteRepository.saveNote(note)
    }
}