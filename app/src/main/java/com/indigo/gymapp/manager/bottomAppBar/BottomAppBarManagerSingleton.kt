package com.indigo.gymapp.manager.bottomAppBar

import com.indigo.gymapp.manager.bottomAppBar.state.Navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BottomAppBarManagerSingleton @Inject constructor() : BottomAppBarManager {

    private var _bottomAppBarState = MutableStateFlow(Navigation)
    val bottomAppBarState = _bottomAppBarState.asStateFlow()


}