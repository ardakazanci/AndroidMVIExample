package com.example.androidmviexample.storage.di

import androidx.room.Room
import com.example.androidmviexample.domain.repositories.NoteRepository
import com.example.androidmviexample.storage.db.AppDatabase
import com.example.androidmviexample.storage.repositories.NotesRepository
import org.koin.dsl.module

val storageModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java, "note_db"
        ).build()
    }

    single { get<AppDatabase>().noteDao() }

    single<NoteRepository> {
        NotesRepository(
           noteDao = get()
        )
    }
}
