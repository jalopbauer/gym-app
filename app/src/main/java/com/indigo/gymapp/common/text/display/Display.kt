package com.indigo.gymapp.common.text.display

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.TextSize

@Composable
fun Display(display: String, textSize : TextSize = Small, color: Color = MaterialTheme.colorScheme.primary, textAlign: TextAlign? = null, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = display,
        color = color,
        textAlign = textAlign,
        style = when(textSize) {
                    Large -> MaterialTheme.typography.displayLarge
                    Medium -> MaterialTheme.typography.displayMedium
                    Small -> MaterialTheme.typography.displayLarge
                }
    )
}
