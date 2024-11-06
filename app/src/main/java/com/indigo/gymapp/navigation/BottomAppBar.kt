package com.indigo.gymapp.navigation

import androidx.annotation.IntRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.bottomAppBar.TabBarItem
import com.indigo.gymapp.common.bottomAppBar.TabBottomBar
import com.indigo.gymapp.common.icon.Calendar
import com.indigo.gymapp.common.icon.Configuration
import com.indigo.gymapp.common.icon.Exercise
import com.indigo.gymapp.common.icon.Routines

@Composable
fun BottomAppBar(
    @IntRange(from = 0, to = 4)
    initialItem: Int,
    onNavigate: (String) -> Unit,
) {

    val exercisesScreen = TabBarItem(title = NavigationPath.Exercises.name, icon = Exercise)
    val calendarScreen = TabBarItem(title = NavigationPath.Calendar.name, icon = Calendar)
    val routinesScreen = TabBarItem(title = NavigationPath.Routines.name, icon = Routines)
    val configScreen = TabBarItem(title = NavigationPath.Configuration.name, icon = Configuration)

    val tabBarItems = listOf(exercisesScreen, calendarScreen, routinesScreen, configScreen)

    TabBottomBar(
        initialItem = initialItem,
        tabBarItems = tabBarItems,
        onNavigate = onNavigate
    )
}


@Preview
@Composable
private fun TabBottomBarVariantPreview() {
    BottomAppBar(
        initialItem = 1,
        onNavigate = { NavigationPath.Exercises.name }
    )
}
