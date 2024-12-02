package com.indigo.gymapp.common.itemSelector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun ItemSelector(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Gap.default)
    ) {
        content()
    }
}