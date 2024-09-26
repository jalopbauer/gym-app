package com.indigo.gymapp.pages.exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.label.Label
import com.indigo.gymapp.pages.exercises.apiExercises.ApiExercises
import com.indigo.gymapp.ui.theme.color.Color.Context

@Composable
fun Exercises() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(stringResource(R.string.local), stringResource(R.string.api))

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = Context.Surface.top
        ) {
            tabs.forEachIndexed { index, label ->
                Tab(
                    text = {
                        Label(label = label, textSize = Large)
                    },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> {
                LocalExercises()
            }
            1 -> {
                ApiExercises()
            }

        }
    }
}