package com.indigo.gymapp.routines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.spacing.Spacing.Context
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun RoutineCard(routine: RoutineEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Context.BorderRadious.card))
            .background(color = Color.Context.Surface.top)
            .padding(Context.Padding.card)
    ) {
        Headline(routine.name)
    }
}