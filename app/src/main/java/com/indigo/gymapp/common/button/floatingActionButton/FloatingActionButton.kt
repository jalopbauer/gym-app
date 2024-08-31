package com.indigo.gymapp.common.button.floatingActionButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.icon.Edit
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.ui.theme.color.Color.Context

@Composable
fun FloatingActionButton(
    iconVariant : IconVariant,
    onClick: () -> Unit,
) {
    val inactiveColor = Context.Surface.primary
    var containerColor = inactiveColor
    androidx.compose.material3.FloatingActionButton(
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