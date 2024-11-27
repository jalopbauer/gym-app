package com.indigo.gymapp.common.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.indigo.gymapp.common.icon.Calendar
import com.indigo.gymapp.common.icon.Configuration
import com.indigo.gymapp.common.icon.Exercise
import com.indigo.gymapp.common.icon.Routines
import com.indigo.gymapp.common.navigation.navigationBarItem.NavigationBarItem
import com.indigo.gymapp.navigation.NavigationPath

@Composable
fun NavigationBar(initialItem: Int, onNavigate: (String) -> Unit) {
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(initialItem)
    }

    val setIndex: (Int) -> Unit = { index -> selectedIndex = index }
    NavigationBar (
        containerColor = MaterialTheme.colorScheme.background
    ) {
        NavigationBarItem(
            name = NavigationPath.Exercises.name,
            iconVariant = Exercise,
            index = NavigationIndex.EXERCISES,
            selectedIndex = selectedIndex,
            setIndex = setIndex,
            onNavigate = onNavigate
        )
        NavigationBarItem(
            name = NavigationPath.Calendar.name,
            iconVariant = Calendar,
            index = NavigationIndex.CALENDAR,
            selectedIndex = selectedIndex,
            setIndex = setIndex,
            onNavigate = onNavigate
        )
        NavigationBarItem(
            name = NavigationPath.Routines.name,
            iconVariant = Routines,
            index = NavigationIndex.ROUTINES,
            selectedIndex = selectedIndex,
            setIndex = setIndex,
            onNavigate = onNavigate
        )
        NavigationBarItem(
            name = NavigationPath.Configuration.name,
            iconVariant = Configuration,
            index = NavigationIndex.CONFIGURATION,
            selectedIndex = selectedIndex,
            setIndex = setIndex,
            onNavigate = onNavigate
        )
    }
}