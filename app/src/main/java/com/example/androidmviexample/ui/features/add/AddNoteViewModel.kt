package com.example.androidmviexample.ui.features.add

import com.example.androidmviexample.domain.model.Note
import com.example.androidmviexample.domain.usecases.SaveNoteUseCase
import com.example.androidmviexample.ui.features.add.AddNoteContract.Event.UpdateFormEvent
import com.example.androidmviexample.ui.features.add.AddNoteContract.State
import com.example.androidmviexample.utils.BaseViewModel
import com.example.androidmviexample.utils.UiState
import com.example.androidmviexample.utils.delegates.DisplaySnackbar
import com.example.androidmviexample.utils.delegates.DisplaySnackbarImpl
import com.example.androidmviexample.utils.successData

class AddNoteViewModel(
    private val saveNoteUseCase: SaveNoteUseCase,
    private val displaySnackbar: DisplaySnackbar = DisplaySnackbarImpl()
) :
    BaseViewModel<State, AddNoteContract.Event>(
        initialState = UiState.Loading
    ), DisplaySnackbar by displaySnackbar {

    override fun handleEvent(event: AddNoteContract.Event) {
        when (event) {
            is UpdateFormEvent -> handleUpdateFormEvent(event)
            is SaveNoteUseCase -> handleSaveNoteEvent()
        }
    }

    private fun handleUpdateFormEvent(event: UpdateFormEvent) {
        updateUiSuccessState {
            it.copy(
                noteTitle = event.noteTitle ?: it.noteTitle,
                noteContent = event.noteContent ?: it.noteContent
            )
        }
    }

    private fun handleSaveNoteEvent() {
        currentState.successData.run {
            val isValid =
                noteTitle.isNotEmpty() && noteContent.isNotEmpty()
            if (isValid) {
                safeLaunch {
                    saveNoteUseCase(
                        Note(
                            noteTitle = noteTitle,
                            noteContent = noteContent
                        )
                    )
                    showSnackbar("New note saved")
                    clearForm()
                }
            } else {
                showSnackbar("not valid")
            }
        }
    }

    private fun clearForm() {
        updateUiSuccessState {
            it.copy(
                noteTitle = "",
                noteContent = ""
            )
        }
    }
}
