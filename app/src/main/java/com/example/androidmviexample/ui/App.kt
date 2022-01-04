package com.example.androidmviexample.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.example.androidmviexample.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        ProvideWindowInsets {
            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute =
                navBackStackEntry?.destination?.route ?: MyDestination.ADD_NOTE

            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar(
                        title = { Text(getTitleForRoute(currentRoute)) }
                    )
                },
                drawerContent = {
                    AppDrawer(
                        currentRoute = getTitleForRoute(currentRoute),
                        navController = navController
                    )
                }
            ) {
                NavGraph(
                    navController = navController,
                    scaffoldState = scaffoldState,
                )
            }
        }
    }
}

fun getTitleForRoute(route: String): String {
    return when (route) {
        MyDestination.ADD_NOTE -> "Add Note"
        else -> "Unknown"
    }
}
