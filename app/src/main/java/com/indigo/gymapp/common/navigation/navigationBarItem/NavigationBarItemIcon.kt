package com.indigo.gymapp.common.navigation.navigationBarItem

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant

@Composable
fun NavigationBarItemIcon(
    selected: Boolean,
    iconVariant: IconVariant
) {
    val tint = if (selected) { MaterialTheme.colorScheme.onSecondary } else { MaterialTheme.colorScheme.primary }
    Icon(
        iconVariant = iconVariant,
        tint = tint
    )
}