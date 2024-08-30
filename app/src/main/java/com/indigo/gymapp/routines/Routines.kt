package com.indigo.gymapp.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Routines(
    onNavigateToCreateRoutine: () -> Unit
) {
    Column (
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text("Routines")
        Button(onClick = onNavigateToCreateRoutine) {
            Text("Add routine")
        }
    }
}