package com.indigo.gymapp.routines

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.header.TextHeader
import com.indigo.gymapp.common.navigation.NavigationIndex
import com.indigo.gymapp.common.page.AddPage
import com.indigo.gymapp.common.page.HeaderPage
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.routines.composable.Routines
import com.indigo.gymapp.routines.manager.RoutineViewModel
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
        bottomAppBarViewModel.setNavigation(NavigationIndex.ROUTINES)
    }

    val coroutineScope = rememberCoroutineScope()

    AddPage (
        onClick = {
            coroutineScope.launch {
                routineViewModel.setInitialRoutine()
            }
            onNavigateToCreateRoutine()
        }
    ) {
        HeaderPage(
            header = {
                TextHeader(
                    text = stringResource(id = R.string.routines)
                )
            }
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
//                TODO Open Bottom Sheet to confirm
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
        }
    }
}