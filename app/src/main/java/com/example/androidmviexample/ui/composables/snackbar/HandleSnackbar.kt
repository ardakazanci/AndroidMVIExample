package com.example.androidmviexample.ui.composables.snackbar

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.androidmviexample.ui.composables.lifecycleAwareState
import com.example.androidmviexample.utils.delegates.DisplaySnackbar

@Composable
fun HandleSnackbar(
    lifecycleOwner: LifecycleOwner,
    viewModel: ViewModel,
    scaffoldState: ScaffoldState
) {
    if (viewModel is DisplaySnackbar) {
        val snackbarState by lifecycleAwareState(
            lifecycleOwner = lifecycleOwner,
            stateFlow = viewModel.snackbarState,
            initialState = viewModel.initialSnackbarState
        )

        if (snackbarState.isShown) {
            LaunchedEffect(scaffoldState.snackbarHostState) {
                when (scaffoldState.snackbarHostState.showSnackbar(snackbarState.message)) {
                    SnackbarResult.Dismissed -> viewModel.dismissSnackbar()
                    SnackbarResult.ActionPerformed -> {
                    }
                    else -> {
                    }
                }
            }
        }
    }
}
