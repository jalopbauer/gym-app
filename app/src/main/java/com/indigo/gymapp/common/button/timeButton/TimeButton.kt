package com.indigo.gymapp.common.button.timeButton

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.domain.time.Time

@Composable
fun TimeButton(
    time: Time,
    onClick: (Time) -> Unit,
) {
    Box(
        modifier = Modifier
            .width(69.dp)
            .height(69.dp)
            .background(color = MaterialTheme.colorScheme.onPrimary, shape = CircleShape)
            .clickable { onClick(time) },
        contentAlignment = Alignment.Center,
    ) {
        Body("$time", Large, MaterialTheme.colorScheme.onBackground)
    }
}