package com.indigo.gymapp.common.deleteButtons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.button.Danger
import com.indigo.gymapp.common.button.Secondary
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun DeleteButtons(cancelOnClick: () -> Unit, deleteOnClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Gap.default)
    ) {
        Button(
            text = stringResource(R.string.cancel),
            onClick = cancelOnClick,
            modifier = Modifier.weight(1f),
            buttonVariant = Secondary
        )
        Button(
            text = stringResource(R.string.delete),
            onClick = deleteOnClick,
            modifier = Modifier.weight(1f),
            buttonVariant = Danger
        )
    }
}