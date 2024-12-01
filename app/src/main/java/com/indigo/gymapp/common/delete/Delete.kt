package com.indigo.gymapp.common.delete

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.deleteButtons.DeleteButtons
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun Delete(
    deleteDescription: String,
    cancelOnClick: () -> Unit,
    deleteOnClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Gap.medium)
    ) {
        Headline(
            headline = deleteDescription,
            textSize = Small
        )
        DeleteButtons(
            cancelOnClick = cancelOnClick,
            deleteOnClick = deleteOnClick
        )
    }
}