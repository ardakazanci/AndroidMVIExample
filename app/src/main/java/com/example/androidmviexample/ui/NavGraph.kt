package com.example.androidmviexample.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidmviexample.ui.features.add.AddNoteScreen

object MyDestination {
    const val ADD_NOTE = "add-note"
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = MyDestination.ADD_NOTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MyDestination.ADD_NOTE) {
            AddNoteScreen(scaffoldState = scaffoldState)
        }
    }
}