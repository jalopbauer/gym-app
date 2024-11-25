package com.indigo.gymapp.common.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.button.iconButton.CancelIconButton
import com.indigo.gymapp.common.button.iconButton.SaveIconButton
import com.indigo.gymapp.common.button.textButton.HeaderTextButton
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.ui.number.Number

@Composable
fun CreateHeader(
    title: String,
    isSelected: Boolean = false,
    onClickDrawerButton: () -> Unit,
    onClickSave: () -> Unit,
    onClickCancel: () -> Unit,

) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Number.Context.Padding.headerWithIconButton),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CancelIconButton { onClickCancel() }
        HeaderTextButton(
            text = title,
            selected = isSelected,
            onClick = onClickDrawerButton
        )
        SaveIconButton { onClickSave() }
    }
}

@Preview
@Composable
private fun UnselectedCreateHeaderPreview() {
    HugPreview {
        CreateHeader (
            title = "header",
            isSelected = false,
            onClickDrawerButton = {},
            onClickSave = {},
            onClickCancel = {}
        )
    }
}

@Preview
@Composable
private fun SelectedCreateHeaderPreview() {
    HugPreview {
        CreateHeader (
            title = "header",
            isSelected = true,
            onClickDrawerButton = {},
            onClickSave = {},
            onClickCancel = {}
        )
    }
}