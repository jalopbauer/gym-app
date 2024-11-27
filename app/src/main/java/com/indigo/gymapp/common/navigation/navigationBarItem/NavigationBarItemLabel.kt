package com.indigo.gymapp.common.navigation.navigationBarItem

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.label.Label

@Composable
fun NavigationBarItemLabel(label: String, selected: Boolean) =
    Label(
        label = label,
        color = if (selected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.primary,
        textSize = Small
    )