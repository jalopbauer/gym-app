package com.indigo.gymapp.manager.bottomAppBar

import androidx.annotation.IntRange

interface BottomAppBarManager {

    fun setCreateUpdateDelete(
        isDeleteEnabled : Boolean,
        isEditEnabled : Boolean,
        addOnClick: () -> Unit,
        editOnClick: () -> Unit,
        deleteOnClick: () -> Unit,
    )

    fun setNavigation(@IntRange(from = 0, to = 4) item: Int,)

    fun setEmpty()
}