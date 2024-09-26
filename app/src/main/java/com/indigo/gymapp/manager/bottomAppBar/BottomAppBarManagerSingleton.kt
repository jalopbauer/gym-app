package com.indigo.gymapp.manager.bottomAppBar

import com.indigo.gymapp.manager.bottomAppBar.state.BottomAppBarManagerState
import com.indigo.gymapp.manager.bottomAppBar.state.CreateUpdateDelete
import com.indigo.gymapp.manager.bottomAppBar.state.Empty
import com.indigo.gymapp.manager.bottomAppBar.state.Navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BottomAppBarManagerSingleton @Inject constructor() : BottomAppBarManager {

    private var _bottomAppBarState = MutableStateFlow<BottomAppBarManagerState>(Navigation)
    val bottomAppBarState: StateFlow<BottomAppBarManagerState> = _bottomAppBarState.asStateFlow()

    override fun setCreateUpdateDelete(
        isDeleteEnabled: Boolean,
        isEditEnabled: Boolean,
        addOnClick: () -> Unit,
        editOnClick: () -> Unit,
        deleteOnClick: () -> Unit
    ) {
        _bottomAppBarState.value = CreateUpdateDelete(
            isDeleteEnabled = isDeleteEnabled,
            isEditEnabled = isEditEnabled,
            addOnClick = addOnClick,
            editOnClick = editOnClick,
            deleteOnClick = deleteOnClick,
        )
    }

    override fun setNavigation() {
        _bottomAppBarState.value = Navigation
    }

    override fun setEmpty() {
        _bottomAppBarState.value = Empty
    }


}