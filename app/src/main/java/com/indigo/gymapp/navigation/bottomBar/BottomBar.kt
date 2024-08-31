package com.indigo.gymapp.navigation.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.navigation.NavigationPath

@Composable
fun BottomBar(
    onNavigate: (String) -> Unit,
) {

    val exercisesScreen = TabBarItem(title = NavigationPath.Exercises.name, icon = Icons.Filled.Home)
    val calendarScreen = TabBarItem(title = NavigationPath.Calendar.name, icon = Icons.Filled.Star)
    val routinesScreen = TabBarItem(title = NavigationPath.Routines.name, icon = Icons.Filled.Person)
    val configScreen = TabBarItem(title = NavigationPath.Configuration.name, icon = Icons.Filled.Build)

    val tabBarItems = listOf(exercisesScreen, calendarScreen, routinesScreen, configScreen)

    TabBottomBar(tabBarItems, onNavigate)
}

@Preview
@Composable
private fun Preview() {
    BottomBar( onNavigate = { NavigationPath.Exercises.name } )
}