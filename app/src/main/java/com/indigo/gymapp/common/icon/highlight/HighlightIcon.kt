package com.indigo.gymapp.common.icon.highlight

import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.ui.number.Number.Component.Icon

@Composable
fun HighlightIcon(iconVariant: IconVariant) {
    Icon(
        iconVariant = iconVariant,
        size = Icon.highlight
    )
}