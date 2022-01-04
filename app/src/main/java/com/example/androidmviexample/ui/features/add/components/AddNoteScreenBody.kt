package com.example.androidmviexample.ui.features.add.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androidmviexample.R
import com.example.androidmviexample.ui.features.add.AddNoteContract
import com.example.androidmviexample.ui.features.add.AddNoteContract.Event.UpdateFormEvent

@Composable
fun AddNoteScreenBody(
    state: AddNoteContract.State,
    eventHandler: (AddNoteContract.Event) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AddNoteForm(
                state = state,
                eventHandler = eventHandler
            )
            Button(
                onClick = {
                    eventHandler.invoke(AddNoteContract.Event.SaveNoteEvent)
                },
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(text = stringResource(id = R.string.save_note))
            }
        }
    }
}

@Composable
fun AddNoteForm(
    state: AddNoteContract.State,
    eventHandler: (AddNoteContract.Event) -> Unit
) {
    Column {
        OutlinedTextField(
            label = stringResource(id = R.string.note_name),
            value = state.noteTitle,
            onChange = {
                eventHandler.invoke(UpdateFormEvent(noteTitle = it))
            }
        )
        OutlinedTextField(
            label = stringResource(id = R.string.note_content),
            value = state.noteContent,
            onChange = {
                eventHandler.invoke(UpdateFormEvent(noteContent = it))
            }
        )
    }
}

@Composable
fun OutlinedTextField(
    label: String = "",
    value: String = "",
    onChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onChange,
        label = { Text(text = label) }
    )
}
