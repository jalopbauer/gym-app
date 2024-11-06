package com.indigo.gymapp.common.bottomAppBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.text.label.Label
import com.indigo.gymapp.ui.theme.color.Color


data class TabBarItem(
    val title: String,
    val icon: IconVariant
)

@Composable
fun TabBottomBar(initialItem: Int, tabBarItems: List<TabBarItem>, onNavigate: (String) -> Unit) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(initialItem)
    }

    NavigationBar (
        containerColor = MaterialTheme.colorScheme.background
    ) {
        tabBarItems.forEachIndexed { index, tabBarItem ->
            val isSelected = selectedTabIndex == index
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    selectedTabIndex = index
                    onNavigate(tabBarItem.title)
                },
                icon = {
                    TabBarIconView(
                        isSelected = isSelected,
                        iconVariant = tabBarItem.icon
                    )
                },
                label = {
                    NavigationBarItemLabel(
                        label = tabBarItem.title,
                        isSelected = isSelected
                    )
                },
                colors = Color.Component.navigationBarItemColors()
            )
        }
    }
}

@Composable
private fun NavigationBarItemLabel(label: String, isSelected: Boolean) =
    Label(
        label = label,
        color = if (isSelected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.primary
    )

@Composable
fun TabBarIconView(
    isSelected: Boolean,
    iconVariant: IconVariant
) {
    val tint = if (isSelected) { MaterialTheme.colorScheme.onSecondary } else { MaterialTheme.colorScheme.primary }
    Icon(
        iconVariant = iconVariant,
        tint = tint
    )
}
