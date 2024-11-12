package com.indigo.gymapp.common.icon.descriptor

import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.ui.spacing.Spacing.Component.Icon.Descriptor

@Composable
fun DescriptorIcon(
    iconVariant: IconVariant
) {
    Icon(
        iconVariant = iconVariant,
        size = Descriptor.size
    )
}