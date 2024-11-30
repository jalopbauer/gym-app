package com.indigo.gymapp.common.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.button.floatingActionButton.FloatingActionButton
import com.indigo.gymapp.common.icon.Add
import com.indigo.gymapp.ui.number.Number.Context.Padding

@Composable
fun AddPage(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        content()
        FloatingActionButton(
            iconVariant = Add,
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(Padding.button)
        )
    }
}