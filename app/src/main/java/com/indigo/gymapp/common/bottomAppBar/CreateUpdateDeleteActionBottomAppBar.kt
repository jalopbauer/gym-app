package com.indigo.gymapp.common.bottomAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.button.floatingActionButton.FloatingActionButton
import com.indigo.gymapp.common.icon.Add
import com.indigo.gymapp.common.icon.button.DeleteIconButton
import com.indigo.gymapp.common.icon.button.EditIconButton
import com.indigo.gymapp.ui.theme.color.Color.Context

@Composable
fun CreateUpdateDeleteActionBottomAppBar(
    addOnClick: () -> Unit,
    editOnClick: () -> Unit,
    deleteOnClick: () -> Unit,
) {
    androidx.compose.material3.BottomAppBar(
        containerColor = Context.Surface.top,
        actions = {
            DeleteIconButton(
                onClick = deleteOnClick
            )
            EditIconButton(
                onClick = editOnClick
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                iconVariant = Add,
                onClick = addOnClick
            )
        }
    )

}

@Preview
@Composable
private fun CreateUpdateDeleteActionBottomAppBarPreview() {
    CreateUpdateDeleteActionBottomAppBar(
        addOnClick = {},
        editOnClick = {},
        deleteOnClick = {},
    )
}