package com.indigo.gymapp.exercises

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.domain.exercises.Exercise
import com.indigo.gymapp.ui.theme.PurpleGrey40
import com.indigo.gymapp.ui.theme.PurpleGrey80

@Composable
fun Exercises() {
    val viewModel = hiltViewModel<ExercisesViewModel>()

    val exercises by viewModel.exercises.collectAsState()
    val loading by viewModel.loadingExercises.collectAsState()
    val showRetry by viewModel.showRetry.collectAsState()

    if(loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.size(64.dp).align(Alignment.Center),
                color = PurpleGrey40,
                trackColor = PurpleGrey80,
            )
        }
    } else if(showRetry) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Retry",
                fontWeight = FontWeight.Bold,
            )
            Text(text = "Retry load ranking")
            Button(onClick = { viewModel.retryLoadingRanking() }) {
                Text(text = "Retry")
            }
        }
    } else {
        LazyColumn {
            items(exercises) { exercise ->
                ExerciseView(exercise = exercise)
            }
        }
    }
}

@Composable
fun ExerciseView(
    exercise: Exercise,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Headline(exercise.name)
    }
    HorizontalDivider()
}