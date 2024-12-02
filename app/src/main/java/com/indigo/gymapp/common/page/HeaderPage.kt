package com.indigo.gymapp.common.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.ui.number.Number.Component.Page
import com.indigo.gymapp.ui.number.Number.Context.Gap
import com.indigo.gymapp.ui.number.Number.Context.Padding

@Composable
fun HeaderPage(
    topPadding : Boolean = false,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        header()
        Column(
            modifier = padding(
                modifier = Modifier.fillMaxSize(),
                topPadding = topPadding),
            verticalArrangement = Arrangement.spacedBy(Gap.default)

        ) {
            content()
        }
    }
}

@Composable
fun padding(modifier: Modifier, topPadding: Boolean) : Modifier =
    if (topPadding) {
        modifier.padding(start = Padding.screen, end = Padding.screen, top = Page.topPadding)
    } else {
        modifier.padding(horizontal = Padding.screen)
    }
