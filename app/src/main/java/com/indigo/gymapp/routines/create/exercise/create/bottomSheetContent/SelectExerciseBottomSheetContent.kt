package com.indigo.gymapp.routines.create.exercise.create.bottomSheetContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.searchBar.SearchBar
import com.indigo.gymapp.ui.spacing.Spacing.Context


@Composable
fun SelectExerciseBottomSheetContent(exerciseName: String, onQueryChange: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxHeight(0.5f),
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        SearchBar(
            query = exerciseName,
            onQueryChange = onQueryChange
        )
    }
}