package com.indigo.gymapp.common.navigation.navigationBarItem

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun RowScope.NavigationBarItem(
    name: String,
    iconVariant: IconVariant,
    index: Int,
    selectedIndex: Int,
    setIndex: (Int) -> Unit,
    onNavigate: (String) -> Unit
) {
    val selected = selectedIndex == index
    NavigationBarItem(
        selected = selected,
        onClick = {
            setIndex(index)
            onNavigate(name)
        },
        icon = {
            NavigationBarItemIcon(
                iconVariant = iconVariant,
                selected = selected
            )
        },
        label = {
            NavigationBarItemLabel(
                label = name,
                selected = selected
            )
        },
        colors = Color.Component.navigationBarItemColors()
    )
}