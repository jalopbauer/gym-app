package com.indigo.gymapp.common.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.button.textInput.HeaderTextDrawerButton
import com.indigo.gymapp.common.icon.button.CancelIconButton
import com.indigo.gymapp.common.icon.button.SaveIconButton
import com.indigo.gymapp.ui.spacing.Spacing

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
            .padding(horizontal = Spacing.Context.Padding.header_with_icon_button),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CancelIconButton { onClickCancel() }
        HeaderTextDrawerButton(
            title = title,
            isSelected = isSelected,
            onClick = onClickDrawerButton
        )
        SaveIconButton { onClickSave() }
    }
}
