package com.indigo.gymapp.manager.bottomAppBar

import androidx.annotation.IntRange
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomAppBarViewModel @Inject constructor(private val bottomAppBarManager: BottomAppBarManagerSingleton) : ViewModel(), BottomAppBarManager {

    override fun setCreateUpdateDelete(
        isDeleteEnabled: Boolean,
        isEditEnabled: Boolean,
        addOnClick: () -> Unit,
        editOnClick: () -> Unit,
        deleteOnClick: () -> Unit
    ) {
        bottomAppBarManager.setCreateUpdateDelete(
            isDeleteEnabled = isDeleteEnabled,
            isEditEnabled = isEditEnabled,
            addOnClick = addOnClick,
            editOnClick = editOnClick,
            deleteOnClick = deleteOnClick,
        )
    }

    override fun setNavigation(@IntRange(from = 0, to = 4) item: Int,) {
        bottomAppBarManager.setNavigation(item)
    }

    override fun setEmpty() {
        bottomAppBarManager.setEmpty()
    }
}