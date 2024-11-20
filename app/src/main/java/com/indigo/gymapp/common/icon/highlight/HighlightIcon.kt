package com.indigo.gymapp.common.icon.highlight

import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.ui.spacing.Spacing.Component.Icon.Highlight

@Composable
fun HighlightIcon(iconVariant: IconVariant) {
    Icon(
        iconVariant = iconVariant,
        size = Highlight.size
    )
}