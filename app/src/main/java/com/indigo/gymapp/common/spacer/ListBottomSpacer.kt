package com.indigo.gymapp.common.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.ui.spacing.Spacing.Context.Spacer

@Composable
fun ListBottomSpacer() {
    Spacer(modifier = Modifier.height(Spacer.listBottom))
}