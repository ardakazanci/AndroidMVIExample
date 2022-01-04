package com.example.androidmviexample.ui.features.add

import com.example.androidmviexample.utils.UiEffect
import com.example.androidmviexample.utils.UiEvent

class AddNoteContract {
    sealed class Event : UiEvent {
        class UpdateFormEvent(
            val noteContent: String? = null,
            val noteTitle: String? = null
        ) : Event()

        object SaveNoteEvent : Event()
    }

    data class State(
        val noteContent: String = "",
        val noteTitle: String = ""
    )

    sealed class Effect : UiEffect
}
