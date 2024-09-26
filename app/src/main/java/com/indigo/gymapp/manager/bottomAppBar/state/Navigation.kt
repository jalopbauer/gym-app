package com.indigo.gymapp.manager.bottomAppBar.state

import androidx.annotation.IntRange

data class Navigation(
    @IntRange(from = 0, to = 4)
    val item: Int,
) : BottomAppBarManagerState