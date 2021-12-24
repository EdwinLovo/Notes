package com.elovo.notes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elovo.notes.presentation.add_edit_note.AddEditNoteScreen
import com.elovo.notes.presentation.notes.NotesScreen
import com.elovo.notes.presentation.util.Screen
import com.elovo.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesApp()
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun NotesApp() {
    NotesTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            NotesNavHost(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun NotesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.NotesScreen.route,
        modifier = modifier
    ) {
        composable(route = Screen.NotesScreen.route) {
            NotesScreen(
                onClickAddNote = {
                    navController.navigate(Screen.AddEditNoteScreen.route)
                },
                onClickEditNote = { note ->
                    navController.navigate(
                        Screen.AddEditNoteScreen.route +
                                "?noteId=${note.id}&noteColor=${note.color}"
                    )
                }
            )
        }
        composable(
            route = Screen.AddEditNoteScreen.route +
                    "?noteId={noteId}&noteColor={noteColor}",
            arguments = listOf(
                navArgument(
                    name = "noteId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(
                    name = "noteColor"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            val color = it.arguments?.getInt("noteColor") ?: -1
            AddEditNoteScreen(
                onClickSaveNote = { navController.navigateUp() },
                noteColor = color
            )
        }
    }
}