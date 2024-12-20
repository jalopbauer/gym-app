package com.indigo.gymapp.calendar.event.routine.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.common.searchList.SearchList
import com.indigo.gymapp.routines.entity.RoutineEntity
import com.indigo.gymapp.time.Rest

@Composable
fun RoutineSearch(
    routineName: String,
    routines: List<RoutineEntity>,
    onQueryChange: (String) -> Unit,
    getRoutineOnClick: (RoutineEntity) -> Unit
) {
    SearchList(
        query = routineName,
        placeholder = stringResource(R.string.search_routine),
        items = routines,
        text = { exercise -> exercise.name},
        onQueryChange = onQueryChange,
        getItemOnClick = getRoutineOnClick
    )
}

@Preview
@Composable
private fun RoutineSearchPreview() {
    HugPreview {
        RoutineSearch(
            routineName = "pu",
            routines = listOf(
                RoutineEntity(
                    name = "Push",
                    rest = Rest(minutes = 2, seconds = 0)
                ),
                RoutineEntity(
                    name = "Pull",
                    rest = Rest(minutes = 2, seconds = 0)
                ),
            ),
            onQueryChange = { },
            getRoutineOnClick = { }
        )
    }
}