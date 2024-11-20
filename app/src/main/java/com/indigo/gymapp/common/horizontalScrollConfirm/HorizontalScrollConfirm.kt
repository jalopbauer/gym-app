package com.indigo.gymapp.common.horizontalScrollConfirm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.numberScroll.HorizontalNumberScroll
import com.indigo.gymapp.common.numberScroll.NumberScroll
import com.indigo.gymapp.time.displaySeconds
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun HorizontalScrollConfirm(
    initialPage: Int,
    selectedItem: (Int) -> Unit,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(space = Spacing.Context.Gap.medium)
    ) {
        val pagerState = rememberPagerState(
            initialPage = initialPage,
            pageCount = { 100 }
        )
        NumberScroll(
            pagerState = pagerState,
            selectedItem = selectedItem,
            indexDisplay = { displaySeconds(it) },
            minimumValue = 1,
            numberScrollVariant = HorizontalNumberScroll
        )
        Button(
            text = stringResource(R.string.confirm),
            onClick = onClick
        )
    }
}