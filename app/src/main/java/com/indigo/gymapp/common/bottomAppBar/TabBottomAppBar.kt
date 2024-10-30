package com.indigo.gymapp.common.bottomAppBar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.indigo.gymapp.common.text.label.Label
import com.indigo.gymapp.ui.theme.color.Color.Context

data class TabBarItem(
    val title: String,
    val icon: ImageVector
)

// TODO Remove background color behind icon
// TODO Change icons

@Composable
fun TabBottomBar(initialItem: Int, tabBarItems: List<TabBarItem>, onNavigate: (String) -> Unit) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(initialItem)
    }

    NavigationBar (
        containerColor = Context.Surface.base
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
                        icon = tabBarItem.icon,
                        title = tabBarItem.title
                    )
                },
                label = {
                    NavigationBarItemLabel(
                        label = tabBarItem.title,
                        isSelected = isSelected
                    )
                }
            )
        }
    }
}

@Composable
private fun NavigationBarItemLabel(label: String, isSelected: Boolean) =
    Label(
        label = label,
        color = if (isSelected) MaterialTheme.colorScheme.onSecondary else Context.Text.primary
    )

@Composable
fun TabBarIconView(
    isSelected: Boolean,
    icon: ImageVector,
    title: String
) {
    val tint = if (isSelected) { MaterialTheme.colorScheme.onSecondary } else { Context.Icon.primary }
    Icon(
        imageVector = icon,
        contentDescription = title,
        tint = tint,
    )
}