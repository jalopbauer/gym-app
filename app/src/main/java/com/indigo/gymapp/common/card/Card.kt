package com.indigo.gymapp.common.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.indigo.gymapp.ui.number.Number.Context.BorderRadius
import com.indigo.gymapp.ui.number.Number.Context.Padding

@Composable
fun Card(onClick: () -> Unit, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(BorderRadius.card))
            .clickable { onClick() }
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(PaddingValues(start = Padding.card)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        content()
    }
}