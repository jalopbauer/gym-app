package com.indigo.gymapp.common.placeholder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title

@Composable
fun Placeholder(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(
            title = text,
            textSize = Medium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}