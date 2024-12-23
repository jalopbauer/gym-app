package com.indigo.gymapp.common.restSelector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.numberScroll.NumberScroll
import com.indigo.gymapp.common.numberScroll.VerticalNumberScroll
import com.indigo.gymapp.common.restSelector.timeButtons.TimeButtons
import com.indigo.gymapp.time.Rest
import com.indigo.gymapp.time.displaySeconds
import com.indigo.gymapp.ui.number.Number.Context.Gap
import kotlinx.coroutines.launch


@Composable
fun RestSelector(
    routineRestTimeBetweenExercises: Rest,
    selectedMinutes: (Int) -> Unit,
    selectedSeconds: (Int) -> Unit,
    leftTime: Rest,
    centerTime: Rest,
    rightTime: Rest,
    confirmOnClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(space = Gap.medium)
    ) {
        val secondsVerticalNumberScrollPagerState = rememberPagerState(
            initialPage = routineRestTimeBetweenExercises.seconds,
            pageCount = { 60 }
        )
        val minutesVerticalNumberScrollPagerState = rememberPagerState(
            initialPage = routineRestTimeBetweenExercises.minutes,
            pageCount = { 60 }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(space = Gap.extraLarge, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberScroll(
                label = stringResource(R.string.minutes),
                pagerState = minutesVerticalNumberScrollPagerState,
                selectedItem = selectedMinutes,
                numberScrollVariant = VerticalNumberScroll
            )
            NumberScroll(
                label = stringResource(R.string.seconds),
                pagerState = secondsVerticalNumberScrollPagerState,
                selectedItem = selectedSeconds,
                indexDisplay = { displaySeconds(it) },
                numberScrollVariant = VerticalNumberScroll
            )
        }
        val coroutineScope = rememberCoroutineScope()

        val onClick: (Rest) -> Unit = {
            coroutineScope.launch {
                secondsVerticalNumberScrollPagerState.scrollToPage(it.seconds)
                minutesVerticalNumberScrollPagerState.scrollToPage(it.minutes)
            }
        }
        TimeButtons(
            leftTime = leftTime,
            leftTimeOnClick = onClick,
            centerTime = centerTime,
            centerTimeOnClick = onClick,
            rightTime = rightTime,
            rightTimeOnClick = onClick
        )
        Button(
            text = stringResource(R.string.confirm),
            onClick = confirmOnClick
        )
    }
}