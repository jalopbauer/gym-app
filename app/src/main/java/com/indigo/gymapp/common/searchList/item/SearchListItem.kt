package com.indigo.gymapp.common.searchList.item

import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.button.textButton.OnlyTextButton

@Composable
fun <T> SearchListItem(
    item: T,
    text : (T) -> String,
    getItemOnClick: (T) -> Unit
) {
    OnlyTextButton(
        text = text(item),
        onClick = {
            getItemOnClick(item)
        }
    )
}