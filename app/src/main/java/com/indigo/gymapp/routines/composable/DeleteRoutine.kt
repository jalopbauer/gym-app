package com.indigo.gymapp.routines.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.delete.Delete

@Composable
fun DeleteRoutine(cancelOnClick: () -> Unit, deleteOnClick: () -> Unit) {
    Delete(
        deleteDescription = stringResource(R.string.deleting_this_will_permanently_delete_your_routine),
        cancelOnClick = cancelOnClick,
        deleteOnClick = deleteOnClick
    )
}