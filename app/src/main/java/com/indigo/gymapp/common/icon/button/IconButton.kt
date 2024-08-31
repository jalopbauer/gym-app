package com.indigo.gymapp.common.icon.button

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.Cancel
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.Save

@Composable
fun IconButton(
    iconVariant : IconVariant,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(iconVariant)
    }
}

@Composable
fun CancelIconButton(onClick: () -> Unit) {
    IconButton(
        iconVariant = Cancel,
        onClick = onClick
    )
}

@Composable
fun SaveIconButton(onClick: () -> Unit) {
    IconButton(
        iconVariant = Save,
        onClick = onClick
    )
}