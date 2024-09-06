package com.indigo.gymapp.common.numberScroll

import androidx.annotation.IntRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.label.Label
import com.indigo.gymapp.ui.spacing.Spacing
import com.indigo.gymapp.ui.theme.color.Color.Context

@Composable
fun VerticalNumberScrollList(
    label: String,
    maxValue: Int,
    minValue: Int = 0,
    startingIndex: Int = 0,
    indexDisplay: (Int) -> String = { "$it" },
    selectedItem: (Int) -> Unit
) {
    val listState = rememberLazyListState()
// Thx chat
    // Scroll to the starting index when the Composable first loads
    LaunchedEffect(key1 = startingIndex) {
        listState.scrollToItem(startingIndex)
    }

    // Compute the selected item index dynamically based on the visible items
    val selectedItemIndex = remember {
        derivedStateOf {
            listState.firstVisibleItemIndex + (listState.layoutInfo.visibleItemsInfo.size / 2)
        }
    }
//
    val selectedNumber = selectedItemIndex.value
    selectedItem(selectedNumber)

    val actualValueModifier = 6
    val actualSize = maxValue + actualValueModifier
    Column (
        verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Label(
            label = label,
            textSize = Large
        )
        LazyColumn(
            modifier = Modifier.height(360.dp),
            state = listState
        ) {
            items(actualSize) { index ->
                val isSelected = index == selectedNumber
                val displayNumber = index - 6 / 2
                val secondary = if (displayNumber in minValue..maxValue) Context.Text.information else Context.Text.transparent
                Text(
                    text = indexDisplay(displayNumber),
                    style = MaterialTheme.typography.displayLarge,
                    color = if (isSelected) Context.Text.primary else secondary
                )
            }
        }
    }
}


@Composable
fun MinuteAndSecondsVerticalScroll(
    label: String,
    @IntRange(from = 0, to = 59) startingIndex: Int = 0,
    selectedItem: (Int) -> Unit
) {
    VerticalNumberScrollList(label = label, maxValue = 59, startingIndex = startingIndex, selectedItem = selectedItem)
}