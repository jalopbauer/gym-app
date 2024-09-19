package com.indigo.gymapp.ui.theme.color

import androidx.compose.ui.graphics.Color

interface ColorTheme {
    val transparent : Color

    fun `neutral-600`() : Color
    fun `neutral-500`() : Color
    fun `neutral-300`() : Color

    fun `greyscale-500`() : Color

    fun `primary-600`() : Color
    fun `primary-500`() : Color
}