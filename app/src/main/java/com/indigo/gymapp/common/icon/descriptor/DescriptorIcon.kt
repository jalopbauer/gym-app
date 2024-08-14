package com.indigo.gymapp.common.icon.descriptor

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun DescriptorIcon(
    imageVector: ImageVector,
    contentDescription: String
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = Color.Context.Icon.primary,
        modifier = Modifier
            .width(16.dp)
            .height(16.dp)
    )
}