package com.indigo.gymapp.common.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.ui.number.Number.Context.Gap
import com.indigo.gymapp.ui.number.Number.Context.Padding

@Composable
fun HeaderPage(
    header: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        header()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Padding.screen),
            verticalArrangement = Arrangement.spacedBy(Gap.default)

        ) {
            content()
        }
    }
}