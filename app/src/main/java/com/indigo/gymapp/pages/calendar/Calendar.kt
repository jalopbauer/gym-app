package com.indigo.gymapp.pages.calendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel

@Composable
fun Calendar() {
    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()

    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(1)
    }
}