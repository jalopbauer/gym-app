package com.indigo.gymapp.common.bottomAppBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.button.floatingActionButton.FloatingActionButton
import com.indigo.gymapp.common.icon.Exercise
import com.indigo.gymapp.common.icon.button.DeleteIconButton
import com.indigo.gymapp.common.icon.button.EditIconButton

@Composable
fun CreateUpdateDeleteBottomAppBar(
    isDeleteEnabled : Boolean,
    isEditEnabled : Boolean,
    addOnClick: () -> Unit,
    editOnClick: () -> Unit,
    deleteOnClick: () -> Unit,
) {
    androidx.compose.material3.BottomAppBar(
        containerColor = MaterialTheme.colorScheme.surface,
        actions = {
            if (isDeleteEnabled) {
                DeleteIconButton(
                    onClick = deleteOnClick
                )
            }
            if (isEditEnabled) {
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
    CreateUpdateDeleteBottomAppBar(
        isDeleteEnabled = false,
        isEditEnabled = false,
        addOnClick = {},
        editOnClick = {},
        deleteOnClick = {},
    )
}

@Preview
@Composable
private fun EditDisabledCreateUpdateDeleteActionBottomAppBarPreview() {
    CreateUpdateDeleteBottomAppBar(
        isDeleteEnabled = true,
        isEditEnabled = false,
        addOnClick = {},
        editOnClick = {},
        deleteOnClick = {},
    )
}

@Preview
@Composable
private fun AllEnabledCreateUpdateDeleteActionBottomAppBarPreview() {
    CreateUpdateDeleteBottomAppBar(
        isDeleteEnabled = true,
        isEditEnabled = true,
        addOnClick = {},
        editOnClick = {},
        deleteOnClick = {},
    )
}



