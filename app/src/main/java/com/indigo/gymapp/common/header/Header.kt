package com.indigo.gymapp.common.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.button.textInput.HeaderTextDrawerButton
import com.indigo.gymapp.ui.theme.color.Content

@Composable
fun CreateHeader(title: String) {
    val onClick = { /*TODO*/ }
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SaveButton(onClick)
        HeaderTextDrawerButton(
            title = title
        )
        CancelButton(onClick)
    }
}

@Composable
private fun CancelButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Outlined.Close,
            contentDescription = "Cancel",
            tint = Content.Icon.primary
        )
    }
}

@Composable
private fun SaveButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = "Save",
            tint = Content.Icon.primary
        )
    }
}

