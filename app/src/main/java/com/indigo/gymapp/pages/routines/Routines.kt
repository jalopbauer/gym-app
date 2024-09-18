package com.indigo.gymapp.pages.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R

@Composable
fun Routines(
    onNavigateToCreateRoutine: () -> Unit
) {
    Column (
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(stringResource(R.string.routines))
        Button(onClick = onNavigateToCreateRoutine) {
            Text(stringResource(R.string.add_routine))
        }
    }
}