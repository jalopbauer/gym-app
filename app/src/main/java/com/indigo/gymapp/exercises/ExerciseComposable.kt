package com.indigo.gymapp.exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.icon.button.DeleteIconButton
import com.indigo.gymapp.common.text.headline.Headline

@Composable
fun Exercise(
    exercise: Exercise,
    deleteOnClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Headline(exercise.name)
        DeleteIconButton(onClick = deleteOnClick)
    }
}