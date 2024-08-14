package com.indigo.gymapp.addRoutine.exercise

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.common.text.body.Body

@Composable
fun TimedExerciseIconTextValue(exercise: TimedExercise) {
    val imageVector = Icons.Outlined.MailOutline
    val contentDescription = "Exercise duration "
    val text = "Duration"

    IconTextValue(imageVector, contentDescription, text) {
        Body(body = "${exercise.duration}")
    }
}