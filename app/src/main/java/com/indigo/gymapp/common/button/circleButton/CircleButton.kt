package com.indigo.gymapp.common.button.circleButton

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.ui.number.Number.Component.Button.CircleButton
import com.indigo.gymapp.ui.theme.color.Color.Component.Button

@Composable
fun CircleButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(CircleButton.diameter),
        shape = CircleShape,
        colors = Button.circleButtonColor(),
        contentPadding = PaddingValues(CircleButton.padding)
    ) {
        Body(body = text, textSize = Large, color = MaterialTheme.colorScheme.onBackground)
    }
}