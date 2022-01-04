package com.example.androidmviexample.domain.model

data class Note(
    val noteId: Long? = null,
    val noteTitle: String,
    val noteContent: String
)