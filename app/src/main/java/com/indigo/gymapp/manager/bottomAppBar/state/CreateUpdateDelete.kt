package com.indigo.gymapp.manager.bottomAppBar.state

data class CreateUpdateDelete(
    val isDeleteEnabled : Boolean = false,
    val isEditEnabled : Boolean = false,
    val addOnClick: () -> Unit = {},
    val editOnClick: () -> Unit = {},
    val deleteOnClick: () -> Unit = {},
) : BottomAppBarManagerState