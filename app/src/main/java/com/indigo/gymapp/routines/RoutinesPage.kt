package com.indigo.gymapp.routines

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.common.button.floatingActionButton.FloatingActionButton
import com.indigo.gymapp.common.icon.Add
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.routines.manager.RoutineViewModel

@Composable
fun Routines(
    onNavigateToCreateRoutine: () -> Unit
) {
    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()
    val routineViewModel = hiltViewModel<RoutineViewModel>()
    val routines by routineViewModel.routines.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(2)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Routines(routines)

        FloatingActionButton(
            iconVariant = Add,
            onClick = onNavigateToCreateRoutine,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}