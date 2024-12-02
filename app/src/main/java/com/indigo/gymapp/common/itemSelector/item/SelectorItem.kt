package com.indigo.gymapp.common.itemSelector.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.highlight.HighlightIcon
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun SelectorItem(
    iconVariant : IconVariant,
    header: String,
    body: String,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Gap.default),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        HighlightIcon(
            iconVariant = iconVariant
        )
        SelectorItemContent(
            header = header,
            body = body
        )
    }
}

