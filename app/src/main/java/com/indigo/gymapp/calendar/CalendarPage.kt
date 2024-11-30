package com.indigo.gymapp.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.header.TextHeader
import com.indigo.gymapp.common.navigation.NavigationIndex
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.ui.number.Number.Context.Padding

@Composable
fun CalendarPage() {

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()
    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(NavigationIndex.CALENDAR)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Padding.screen),
    ) {
        TextHeader(
            text = stringResource(R.string.calendar)
        )
    }
}