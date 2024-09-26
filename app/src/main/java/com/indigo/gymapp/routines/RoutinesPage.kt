package com.indigo.gymapp.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel

@Composable
fun Routines(
    onNavigateToCreateRoutine: () -> Unit
) {
    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()

    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(2)
    }

    Column (
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(stringResource(R.string.routines))
        Button(onClick = onNavigateToCreateRoutine) {
            Text(stringResource(R.string.add_routine))
        }
    }
}