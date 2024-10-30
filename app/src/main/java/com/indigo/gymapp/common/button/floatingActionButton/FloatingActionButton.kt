package com.indigo.gymapp.common.button.floatingActionButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.icon.Edit
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.ui.theme.color.Color.Context

@Composable
fun FloatingActionButton(
    modifier: Modifier = Modifier,
    iconVariant : IconVariant,
    onClick: () -> Unit,
) {
    val inactiveColor = MaterialTheme.colorScheme.secondary
    var containerColor = inactiveColor
    androidx.compose.material3.FloatingActionButton(
        modifier = modifier,
        onClick = {
            containerColor = Context.Surface.active
            onClick()
            containerColor = inactiveColor

        },
        containerColor = containerColor
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