package com.indigo.gymapp.common.iconTextValue

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.descriptor.DescriptorIcon
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun IconTextValue(
    iconVariant: IconVariant,
    label: String,
    value: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Gap.space),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DescriptorIcon(
            iconVariant = iconVariant,
        )
        Body(body = label, textSize = Small)
        Body(body = value, textSize = Small)
    }
}