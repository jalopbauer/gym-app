package com.indigo.gymapp.common.icon.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun IconButton(
    imageVector: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = Color.Context.Icon.primary
        )
    }
}

@Composable
fun CancelIconButton(onClick: () -> Unit) {
    IconButton(
        imageVector = Icons.Outlined.Close,
        contentDescription = "Cancel",
        onClick = onClick
    )
}

@Composable
fun SaveIconButton(onClick: () -> Unit) {
    IconButton(
        imageVector = Icons.Outlined.Add,
        contentDescription = "Save",
        onClick = onClick
    )
}