package com.indigo.gymapp.common.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun Icon(iconVariant : IconVariant) {
    when (iconVariant) {
        Save -> SaveIcon()
        Cancel -> CancelIcon()
    }
}

@Composable
private fun ImageVectorIcon(
    imageVector: ImageVector,
    contentDescription: String,
) {
    androidx.compose.material3.Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = Color.Context.Icon.primary
    )
}

@Composable
fun CancelIcon() {
    ImageVectorIcon(Icons.Outlined.Close, "Cancel")
}

@Composable
fun SaveIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Add,
        contentDescription = "Save",
    )
}


sealed interface IconVariant

data object Save : IconVariant

data object Cancel : IconVariant