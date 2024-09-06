package com.indigo.gymapp.common.numberScroll

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.ui.theme.color.Color.Context

@Composable
fun VerticalNumberScrollList(
    maxValue: Int,
    minValue: Int = 0,
    startingIndex: Int = 0,
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
    LazyColumn(
        modifier = Modifier.height(360.dp),
        state = listState
    ) {
        items(actualSize) { index ->
            val isSelected = index == selectedNumber
            val displayNumber = index - 6 / 2
            val displayValue = if (displayNumber in 0 .. 9) "0$displayNumber" else displayNumber
            val secondary = if (displayNumber in minValue..maxValue) Context.Text.information else Context.Text.transparent
            Text(
                text = "$displayValue",
                style = MaterialTheme.typography.displayLarge,
                color = if (isSelected) Context.Text.primary else secondary
            )
        }
    }
}
