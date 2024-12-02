package com.indigo.gymapp.common.itemSelector.item

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.common.text.headline.Headline

@Composable
fun SelectorItemContent(
    header: String,
    body: String
) {
    Column {
        Headline(
            headline = header,
            textSize = Small
        )
        Body(
            body = body,
            textSize = Small
        )
    }
}