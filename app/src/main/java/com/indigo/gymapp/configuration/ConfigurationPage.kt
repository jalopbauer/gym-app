package com.indigo.gymapp.configuration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.number.Number.Context.Padding

@Composable
fun ConfigurationPage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Padding.screen),
    ) {
        Headline(
            headline = stringResource(R.string.configuration),
            textSize = Large
        )
    }
}