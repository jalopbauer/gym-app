package com.indigo.gymapp.common.iconTextValue

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import com.indigo.gymapp.common.icon.descriptor.DescriptorIcon
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun IconTextValue(
    imageVector: ImageVector,
    contentDescription: String,
    text: String,
    content: @Composable () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.space),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DescriptorIcon(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
        Body(body = text)
        content()
    }
}