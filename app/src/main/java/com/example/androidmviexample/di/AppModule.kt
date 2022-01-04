package com.example.androidmviexample.di

import com.example.androidmviexample.ExampleAppConfiguration
import com.example.androidmviexample.domain.AppConfiguration
import com.example.androidmviexample.ui.features.add.AddNoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<AppConfiguration> {
        ExampleAppConfiguration()
    }

    viewModel {
        AddNoteViewModel(
            saveNoteUseCase = get(),
            canDisplaySnackbar = get()
        )
    }
}
