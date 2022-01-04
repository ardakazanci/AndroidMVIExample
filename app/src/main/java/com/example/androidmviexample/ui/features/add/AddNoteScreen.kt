package com.example.androidmviexample.ui.features.add

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidmviexample.ui.composables.BaseComposeScreen
import com.example.androidmviexample.ui.features.add.components.AddNoteScreenBody
import com.example.androidmviexample.utils.successData
import org.koin.androidx.compose.getViewModel

@Preview
@Composable
fun AddNoteScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    viewModel: AddNoteViewModel = getViewModel()
) {
    BaseComposeScreen(
        scaffoldState = scaffoldState,
        viewModel = viewModel
    ) { state, eventHandler ->
        Scaffold {
            AddNoteScreenBody(
                state = state.successData,
                eventHandler = eventHandler
            )
        }
    }
}
