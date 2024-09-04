package com.indigo.gymapp.navigation

import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class NavigationViewModel @Inject constructor() {

    private var _displayBottomTabBar = MutableStateFlow(true)
    val displayBottomTabBar = _displayBottomTabBar.asStateFlow()
    private val onListner = NavController.OnDestinationChangedListener { _, destination, _ ->
        _displayBottomTabBar.value = destination.navigatorName == NavigationPath.Routines.Create.name

    }
}