package com.indigo.gymapp.common.numberScroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.display.Display
import com.indigo.gymapp.common.text.label.Label
import com.indigo.gymapp.ui.number.Number.Component.NumberScroll
import com.indigo.gymapp.ui.number.Number.Context.Gap


@Composable
fun NumberScroll(
    label: String? = null,
    pagerState: PagerState,
    indexDisplay: (Int) -> String = { "$it" },
    selectedItem: (Int) -> Unit,
    minimumValue: Int = 0,
    numberScrollVariant: NumberScrollVariant
) {

    LaunchedEffect(pagerState.settledPage) {
        ensurePageIsAtLeastMinimumValue(pagerState, minimumValue)
    }

    selectedItem(pagerState.settledPage)
    val currentPage = pagerState.currentPage

    Column(
        verticalArrangement = Arrangement.spacedBy(Gap.default),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        label?.let {
            Label(
                label = label,
                textSize = Large
            )
        }
        when (numberScrollVariant) {
            HorizontalNumberScroll -> {
                HorizontalNumberScroll(
                    pagerState = pagerState,
                ) { page ->
                    Number(
                        value = page,
                        currentPage = currentPage,
                        indexDisplay = indexDisplay,
                        minimumValue = minimumValue
                    )
                }
            }
            VerticalNumberScroll -> {
                VerticalNumberScroll(
                    pagerState = pagerState,
                ) { page ->
                    Number(
                        value = page,
                        currentPage = currentPage,
                        indexDisplay = indexDisplay,
                        minimumValue = minimumValue
                    )
                }
            }
        }
    }
}

private suspend fun ensurePageIsAtLeastMinimumValue(
    pagerState: PagerState,
    minimumValue: Int
) {
    if (pagerState.settledPage < minimumValue) {
        pagerState.scrollToPage(minimumValue)
    }
}

sealed interface NumberScrollVariant

data object VerticalNumberScroll : NumberScrollVariant

data object HorizontalNumberScroll : NumberScrollVariant

@Composable
fun Number(
    value: Int,
    currentPage: Int,
    indexDisplay: (Int) -> String,
    minimumValue: Int
) {
    val selected = value == currentPage
    if (value >= minimumValue){
        Display(
            modifier = Modifier.width(NumberScroll.pageSize),
            display = indexDisplay(value),
            color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Right,
            textSize = Large
        )
    }
}

@Composable
private fun VerticalNumberScroll(
    pagerState: PagerState,
    content : @Composable (Int) -> Unit
) {
    VerticalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(NumberScroll.pageSize),
        modifier = Modifier.height(NumberScroll.verticalPagerHeight),
        horizontalAlignment = Alignment.End,
        contentPadding = NumberScroll.verticalPaddingValues
    ) { page ->
        content(page)
    }
}

@Composable
private fun HorizontalNumberScroll(
    pagerState: PagerState,
    content : @Composable (Int) -> Unit
) {
    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(NumberScroll.pageSize),
        contentPadding = NumberScroll.horizontalPaddingValues,
        pageSpacing = Gap.default
    ) { page ->
        content(page)
    }
}