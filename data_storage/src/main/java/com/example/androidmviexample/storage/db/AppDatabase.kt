package com.example.androidmviexample.storage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidmviexample.storage.dao.NoteDao
import com.example.androidmviexample.storage.entity.NoteEntity

@Database(
    entities = [NoteEntity::class],
    exportSchema = false,
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
