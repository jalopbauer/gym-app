package com.indigo.gymapp.common.icon.descriptor

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant

@Composable
fun DescriptorIcon(
    iconVariant: IconVariant
) {
    Icon(
        iconVariant = iconVariant,
        size = 16.dp
    )
}