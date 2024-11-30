package com.indigo.gymapp.configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.header.TextHeader
import com.indigo.gymapp.common.navigation.NavigationIndex
import com.indigo.gymapp.common.page.HeaderPage
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel

@Composable
fun ConfigurationPage() {

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()
    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(NavigationIndex.CONFIGURATION)
    }

    HeaderPage(
        header = {
            TextHeader(
                text = stringResource(R.string.configuration)
            )
        }
    ) {}
}