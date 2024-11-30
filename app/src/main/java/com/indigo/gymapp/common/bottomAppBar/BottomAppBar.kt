package com.indigo.gymapp.common.bottomAppBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.button.floatingActionButton.FloatingActionButton
import com.indigo.gymapp.common.button.iconButton.DeleteIconButton
import com.indigo.gymapp.common.button.iconButton.EditIconButton
import com.indigo.gymapp.common.icon.Exercise

@Composable
fun BottomAppBar(
    showDelete : Boolean,
    showEdit : Boolean,
    addOnClick: () -> Unit,
    editOnClick: () -> Unit,
    deleteOnClick: () -> Unit,
) {
    androidx.compose.material3.BottomAppBar(
        containerColor = MaterialTheme.colorScheme.surface,
        actions = {
            if (showDelete) {
                DeleteIconButton(
                    onClick = deleteOnClick
                )
            }
            if (showEdit) {
                EditIconButton(
                    onClick = editOnClick
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                iconVariant = Exercise,
                onClick = addOnClick
            )
        }
    )

}

@Preview
@Composable
private fun DeleteAndEditDisabledCreateUpdateDeleteActionBottomAppBarPreview() {
    BottomAppBar(
        showDelete = false,
        showEdit = false,
        addOnClick = {},
        editOnClick = {},
        deleteOnClick = {},
    )
}

@Preview
@Composable
private fun EditDisabledCreateUpdateDeleteActionBottomAppBarPreview() {
    BottomAppBar(
        showDelete = true,
        showEdit = false,
        addOnClick = {},
        editOnClick = {},
        deleteOnClick = {},
    )
}

@Preview
@Composable
private fun AllEnabledCreateUpdateDeleteActionBottomAppBarPreview() {
    BottomAppBar(
        showDelete = true,
        showEdit = true,
        addOnClick = {},
        editOnClick = {},
        deleteOnClick = {},
    )
}



