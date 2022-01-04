package com.example.androidmviexample.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey val noteId: Long? = null,
    val noteTitle: String,
    val noteContent: String
)
