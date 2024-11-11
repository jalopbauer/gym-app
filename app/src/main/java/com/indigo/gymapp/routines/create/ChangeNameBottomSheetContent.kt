package com.indigo.gymapp.routines.create

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.indigo.gymapp.R
import com.indigo.gymapp.common.textField.TextField

@Composable
fun ChangeNameBottomSheetContent(
    routineName: String,
    onValueChange: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                focusRequester.requestFocus()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    TextField(
        value = routineName,
        label = stringResource(id = R.string.name_your_routine),
        onValueChange = onValueChange,
        modifier = Modifier.focusRequester(focusRequester)
    )
}