package com.indigo.gymapp.common.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.button.floatingActionButton.FloatingActionButton
import com.indigo.gymapp.common.button.floatingActionButton.Small
import com.indigo.gymapp.common.icon.Add
import com.indigo.gymapp.common.icon.Edit
import com.indigo.gymapp.ui.number.Number.Component.Page
import com.indigo.gymapp.ui.number.Number.Context.Padding

@Composable
fun AddEditPage(
    showAdd : Boolean = true,
    addOnClick: () -> Unit,
    showEdit : Boolean = true,
    editOnClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        content()
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(Padding.button),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Page.fabGap, Alignment.Bottom)
        ) {
            if (showEdit) {
                FloatingActionButton(
                    iconVariant = Edit,
                    size = Small,
                    onClick = editOnClick,
                )
            }
            if (showAdd) {
                FloatingActionButton(
                    iconVariant = Add,
                    onClick = addOnClick,
                )
            }
        }
    }
}