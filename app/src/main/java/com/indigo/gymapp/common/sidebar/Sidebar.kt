package com.indigo.gymapp.common.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.ui.number.Number.Component.Sidebar

@Composable
fun Sidebar(
    selected : Boolean
) {
    Spacer(
        modifier = Modifier
            .height(Sidebar.height)
            .width(Sidebar.width)
            .clip(
                RoundedCornerShape(Sidebar.borderRadius)
            )
            .background(
                color = if (selected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onPrimary
            )
    )
}

@Preview
@Composable
private fun SelectedSidebarPreview() {
    HugPreview {
        Sidebar(selected = true)
    }
}

@Preview
@Composable
private fun UnselectedSidebarPreview() {
    HugPreview {
        Sidebar(selected = false)
    }
}