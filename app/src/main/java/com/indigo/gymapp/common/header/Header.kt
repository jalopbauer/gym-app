package com.indigo.gymapp.common.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.number.Number.Component.Header.CreateHeader
import com.indigo.gymapp.ui.number.Number.Context.Padding

@Composable
fun TextHeader(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Padding.screen),
    ) {
        Headline(
            headline = text,
            textSize = Large
        )
    }
}

@Composable
fun CreateHeader(
    text: String,
    selected: Boolean,
    onClickTextButton: () -> Unit,
    onClickSave: () -> Unit,
    onClickCancel: () -> Unit,

    ) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = CreateHeader.horizontalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CancelIconButton(
            onClick = onClickCancel
        )
        HeaderTextButton(
            text = text,
            selected = selected,
            onClick = onClickTextButton
        )
        SaveIconButton(
            onClick = onClickSave
        )
    }
}

@Preview
@Composable
private fun UnselectedCreateHeaderPreview() {
    HugPreview {
        CreateHeader (
            text = "header",
            selected = false,
            onClickTextButton = {},
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
            text = "header",
            selected = true,
            onClickTextButton = {},
            onClickSave = {},
            onClickCancel = {}
        )
    }
}