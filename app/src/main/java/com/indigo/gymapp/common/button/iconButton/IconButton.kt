package com.indigo.gymapp.common.button.iconButton

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.indigo.gymapp.common.icon.Cancel
import com.indigo.gymapp.common.icon.Delete
import com.indigo.gymapp.common.icon.Edit
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.Save

@Composable
fun IconButton(
    iconVariant : IconVariant,
    tint: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            iconVariant = iconVariant,
            tint = tint
        )
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

@Composable
fun DeleteIconButton(onClick: () -> Unit) {
    IconButton(
        iconVariant = Delete,
        onClick = onClick
    )
}

@Composable
fun EditIconButton(onClick: () -> Unit) {
    IconButton(
        iconVariant = Edit,
        onClick = onClick
    )
}