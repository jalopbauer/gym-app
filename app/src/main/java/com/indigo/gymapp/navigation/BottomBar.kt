package com.indigo.gymapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.text.label.Label
import com.indigo.gymapp.ui.theme.color.Color.Context

// TODO Remove background color behind icon
// TODO Change icons

@Composable
fun BottomBar(
    onNavigate: (String) -> Unit,
) {

    val exercisesScreen = TabBarItem(title = NavigationPath.Exercises.name, icon = Icons.Filled.Home)
    val calendarScreen = TabBarItem(title = NavigationPath.Calendar.name, icon = Icons.Filled.Star)
    val routinesScreen = TabBarItem(title = NavigationPath.Routines.name, icon = Icons.Filled.Person)
    val configScreen = TabBarItem(title = NavigationPath.Configuration.name, icon = Icons.Filled.Build)

    val tabBarItems = listOf(exercisesScreen, calendarScreen, routinesScreen, configScreen)

    TabView(tabBarItems, onNavigate)
}

data class TabBarItem(
    val title: String,
    val icon: ImageVector
)

@Composable
fun TabView(tabBarItems: List<TabBarItem>, onNavigate: (String) -> Unit) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
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
        color = if (isSelected) {
            Context.Text.active
        } else {
            Context.Text.primary
        }
    )

@Composable
fun TabBarIconView(
    isSelected: Boolean,
    icon: ImageVector,
    title: String
) {
    val tint = if (isSelected) { Context.Icon.active } else { Context.Icon.primary }
    Icon(
        imageVector = icon,
        contentDescription = title,
        tint = tint,

    )
}

@Preview
@Composable
private fun Preview() {
    BottomBar { NavigationPath.Exercises.name }
}