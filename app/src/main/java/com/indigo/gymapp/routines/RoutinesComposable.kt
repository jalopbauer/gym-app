package com.indigo.gymapp.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun Routines(
    routines: List<RoutineEntity>,
    onCardClick: (Long) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(space = Context.Gap.default)
    ) {
        Headline(
            headline = stringResource(id = R.string.routines),
            textSize = Large
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(space = Context.Gap.default)
        ) {
            items(routines) { routine ->
                RoutineCard(
                    routine = routine,
                    onCardClick = onCardClick
                )
            }
        }
    }
}