package com.example.androidmviexample.utils.delegates

import com.example.androidmviexample.utils.SnackbarState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface DisplaySnackbar {
    val initialSnackbarState: SnackbarState
    val _snackbarState: MutableStateFlow<SnackbarState>
    val snackbarState: StateFlow<SnackbarState>

    fun showSnackbar(message: String)

    fun dismissSnackbar()
}

class DisplaySnackbarImpl(
    override val initialSnackbarState: SnackbarState = SnackbarState()
) : DisplaySnackbar {

    override val _snackbarState: MutableStateFlow<SnackbarState> by lazy {
        MutableStateFlow(initialSnackbarState)
    }
    override val snackbarState: StateFlow<SnackbarState> = _snackbarState.asStateFlow()

    private val currentSnackbarState: SnackbarState
        get() = snackbarState.value

    override fun showSnackbar(message: String) {
        _snackbarState.value = currentSnackbarState.copy(isShown = true, message = message)
    }

    override fun dismissSnackbar() {
        _snackbarState.value = currentSnackbarState.copy(isShown = false)
    }
}