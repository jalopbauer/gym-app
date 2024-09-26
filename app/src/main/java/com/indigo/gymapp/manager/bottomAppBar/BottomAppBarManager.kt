package com.indigo.gymapp.manager.bottomAppBar

interface BottomAppBarManager {

    fun setCreateUpdateDelete(
        isDeleteEnabled : Boolean,
        isEditEnabled : Boolean,
        addOnClick: () -> Unit,
        editOnClick: () -> Unit,
        deleteOnClick: () -> Unit,
    )

    fun setNavigation()

    fun setEmpty()
}