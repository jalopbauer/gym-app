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
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.ui.spacing.Spacing.Context.Padding

@Composable
fun CalendarPage() {
    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()

    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Padding.screen),
    ) {
        Headline(
            headline = stringResource(R.string.calendar),
            textSize = Large
        )
    }
}