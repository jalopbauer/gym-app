package com.indigo.gymapp.common.page

import androidx.compose.runtime.Composable

@Composable
fun AddPage(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    AddEditPage(
        addOnClick = onClick,
        showEdit = false,
        editOnClick = {},
        content = content
    )
}