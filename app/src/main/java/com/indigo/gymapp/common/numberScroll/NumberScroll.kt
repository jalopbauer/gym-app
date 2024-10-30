package com.indigo.gymapp.common.numberScroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.label.Label
import com.indigo.gymapp.ui.spacing.Spacing

// TODO Create one component with a variant parameter
@Composable
fun VerticalNumberScroll(
    label: String,
    pagerState: PagerState,
    indexDisplay: (Int) -> String = { "$it" },
    selectedItem: (Int) -> Unit
) {
    selectedItem(pagerState.settledPage)
    val verticalPagerHeight = 360.dp
    val pageSize = 64.dp
    Column (
        verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Label(
            label = label,
            textSize = Large
        )
        VerticalPager(
            state = pagerState,
            pageSize = PageSize.Fixed(pageSize),
            modifier = Modifier.height(verticalPagerHeight),
            horizontalAlignment = Alignment.End,
            contentPadding = PaddingValues(vertical = (verticalPagerHeight - pageSize) / 2)

        ) { page ->
            val isSelected = page == pagerState.currentPage
            Text(
                modifier = Modifier.width(pageSize),
                text = indexDisplay(page),
                style = MaterialTheme.typography.displayLarge,
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Right
            )
        }
    }
}

@Composable
fun HorizontalNumberScroll(
    label: String? = null,
    pagerState: PagerState,
    indexDisplay: (Int) -> String = { "$it" },
    selectedItem: (Int) -> Unit
) {
    val pageSize = 64.dp
    selectedItem(pagerState.settledPage)
    Column (
        verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        label?.let {
            Label(
                label = label,
                textSize = Large
            )
        }
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fixed(pageSize),
            contentPadding = PaddingValues(horizontal = pageSize * 2 + pageSize / 4),
            pageSpacing = Spacing.Context.Gap.default
        ) { page ->
            val isSelected = page == pagerState.currentPage
            Text(
                modifier = Modifier.width(pageSize),
                text = indexDisplay(page),
                style = MaterialTheme.typography.displayLarge,
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Right
            )
        }
    }
}