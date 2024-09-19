package com.indigo.gymapp.ui.theme.color

import androidx.compose.ui.graphics.Color

object NordDark : ColorTheme {

    override val transparent: Color = Color(0x00000000)
    override fun `neutral-600`(): Color = Color(0xFF2E3440)
    override fun `neutral-500`(): Color = Color(0xFF3B4252)
    override fun `neutral-300`(): Color = Color(0xFF4C566A)

    override fun `greyscale-500`(): Color = Color(0xFFECEFF4)

    override fun `primary-600`(): Color = Color(0xFF5E81AC)
    override fun `primary-500`(): Color = Color(0xFF81A1C1)
}