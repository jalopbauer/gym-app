package com.indigo.gymapp.exercises.apiExercises

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.exercises.viewModel.ExerciseViewModel
import com.indigo.gymapp.service.api.exercises.Exercise
import com.indigo.gymapp.ui.theme.PurpleGrey40
import com.indigo.gymapp.ui.theme.PurpleGrey80

@Composable
fun ApiExercises() {
    val viewModel = hiltViewModel<ApiExercisesViewModel>()

    val exercises by viewModel.exercises.collectAsState()
    val loading by viewModel.loadingExercises.collectAsState()
    val showRetry by viewModel.showRetry.collectAsState()

    val exerciseViewModel = hiltViewModel<ExerciseViewModel>()

    if (loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.Center),
                color = PurpleGrey40,
                trackColor = PurpleGrey80,
            )
        }
    } else if (showRetry) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.retry),
                fontWeight = FontWeight.Bold,
            )
            Text(text = stringResource(R.string.retry_load_ranking))
            Button(onClick = { viewModel.retryLoadingRanking() }) {
                Text(text = stringResource(R.string.retry))
            }
        }
    } else {
        LazyColumn {
            items(exercises) { exercise ->
                ExerciseView(
                    exercise = exercise,
                    getExerciseOnClick = { exerciseViewModel.createExercise( it.name )}
                )
            }
        }
    }
}

@Composable
fun ExerciseView(
    exercise: Exercise,
    getExerciseOnClick: (Exercise) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { getExerciseOnClick(exercise) },
    ) {
        Headline(exercise.name)
    }
    HorizontalDivider()
}