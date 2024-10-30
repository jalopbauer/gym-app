package com.indigo.gymapp.common.button.floatingActionButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.icon.Edit
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant

@Composable
fun FloatingActionButton(
    modifier: Modifier = Modifier,
    iconVariant : IconVariant,
    onClick: () -> Unit,
) {
    androidx.compose.material3.FloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(iconVariant)
    }
}

@Preview
@Composable
private fun FloatingActionButtonPreview() {
    FloatingActionButton(
        iconVariant = Edit,
        onClick = {}
    )
}