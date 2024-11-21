package com.indigo.gymapp.common.iconTextValue

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.descriptor.DescriptorIcon
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.ui.number.Number

@Composable
fun IconTextValue(
    iconVariant: IconVariant,
    text: String,
    content: @Composable () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Number.Context.Gap.space),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DescriptorIcon(
            iconVariant = iconVariant,
        )
        Body(body = text)
        content()
    }
}