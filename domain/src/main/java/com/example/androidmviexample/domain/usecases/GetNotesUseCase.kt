package com.example.androidmviexample.domain.usecases

import com.example.androidmviexample.domain.model.Note
import com.example.androidmviexample.domain.repositories.NoteRepository

interface GetNotesUseCase {
    suspend operator fun invoke(): List<Note>
}

class GetNotesUseCaseImpl(
    private val noteRepository: NoteRepository
) : GetNotesUseCase {
    override suspend fun invoke(): List<Note> {
        return noteRepository.getNotes()
    }
}
