package com.indigo.gymapp.calendar.event.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun EmptyEvent(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = Gap.space,
            alignment = Alignment.CenterHorizontally
        ),
    ) {
        Title(
            title = stringResource(R.string.no_activity_for),
            textSize = Medium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Title(
            title = text,
            textSize = Medium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
private fun EmptyEmptyEventToday() {
    HugPreview {
        EmptyEvent(
            text = "today"
        )
    }
}