package com.indigo.gymapp.routines

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.floatingActionButton.FloatingActionButton
import com.indigo.gymapp.common.icon.Add
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.routines.composable.Routines
import com.indigo.gymapp.routines.manager.RoutineViewModel
import com.indigo.gymapp.ui.number.Number.Context.Padding
import kotlinx.coroutines.launch

@Composable
fun RoutinesPage(
    onNavigateToCreateRoutine: () -> Unit
) {
    val context = LocalContext.current

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()
    val routineViewModel = hiltViewModel<RoutineViewModel>()
    val routines by routineViewModel.routines.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(2)
    }

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Routines(
            routines = routines,
            onCardClick = {
                coroutineScope.launch {
                    routineViewModel.setRoutineId(it)
                    onNavigateToCreateRoutine()
                }
            },
            onDeleteClick = {
                coroutineScope.launch {
                    routineViewModel.deleteRoutine(it)
                }
                Toast.makeText(
                    context,
                    context.getString(R.string.routine_deleted),
                    Toast.LENGTH_SHORT
                ).show()
            }
        )

        FloatingActionButton(
            iconVariant = Add,
            onClick = {
                coroutineScope.launch {
                    routineViewModel.setInitialRoutine()
                }
                onNavigateToCreateRoutine()
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(Padding.button)
        )
    }
}