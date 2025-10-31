package com.example.notekeeperapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notekeeperapp.ui.screens.AddNoteScreen
import com.example.notekeeperapp.ui.screens.NoteListScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

//    NavHost(navController = navController, startDestination = "add_note_screen") {
//        composable(route = "add_note_screen") { AddNoteScreen { navController.navigate("note_list_screen") } }
//        composable(route = "note_list_screen") { NoteListScreen() }
//    }
}