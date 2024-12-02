package com.indigo.gymapp.common.button.floatingActionButton

import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.icon.Add
import com.indigo.gymapp.common.icon.Edit
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.ui.number.Number.Component.Button.FloatingActionButton

@Composable
fun FloatingActionButton(
    modifier: Modifier = Modifier,
    size: Size = Default,
    iconVariant : IconVariant,
    onClick: () -> Unit,
) {
    val sizeValue = when (size) {
        Small -> FloatingActionButton.Size.small
        Default -> FloatingActionButton.Size.default
    }

    androidx.compose.material3.FloatingActionButton(
        modifier = modifier.size(sizeValue),
        shape = when (size) {
            Default -> FloatingActionButtonDefaults.shape
            Small -> FloatingActionButtonDefaults.smallShape
        },
        onClick = onClick,
        containerColor = when (size) {
            Default -> MaterialTheme.colorScheme.secondary
            Small -> MaterialTheme.colorScheme.onPrimary
        }
    ) {
        Icon(iconVariant)
    }
}

sealed interface Size

data object Default : Size

data object Small : Size

@Preview
@Composable
private fun FloatingActionButtonDefaultPreview() {
    FloatingActionButton(
        iconVariant = Add,
        onClick = {}
    )
}

@Preview
@Composable
private fun FloatingActionButtonSmallPreview() {
    FloatingActionButton(
        iconVariant = Edit,
        size = Small,
        onClick = {}
    )
}