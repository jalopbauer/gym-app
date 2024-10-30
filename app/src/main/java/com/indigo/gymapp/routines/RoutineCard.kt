package com.indigo.gymapp.routines

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.indigo.gymapp.common.icon.button.DeleteIconButton
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun RoutineCard(
    routine: RoutineEntity,
    onCardClick: (Long) -> Unit,
    onDeleteClick: (Long) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Context.BorderRadious.card))
            .clickable { onCardClick(routine.id) }
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(PaddingValues(start=Context.Padding.card)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Headline(routine.name)
        DeleteIconButton(onClick = {onDeleteClick(routine.id)})
    }
}