package com.indigo.gymapp.common.button.circleButton

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.body.Body

@Composable
fun CircleButton(
    text: String,
    onClick: () -> Unit,
    size: Dp,
    padding: Dp,
    colors: ButtonColors
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(size),
        shape = CircleShape,
        colors = colors,
        contentPadding = PaddingValues(padding)
    ) {
        Body(body = text, textSize = Large, color = MaterialTheme.colorScheme.onBackground)
    }
}