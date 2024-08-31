package com.indigo.gymapp.ui.theme.color

import androidx.compose.ui.graphics.Color

object Color {
    private object Brand {
//        TODO Brand should implement interface ColorTheme
        object Neutral {
            fun `600`() = Color(0xFF2E3440)
            fun `500`() = Color(0xFF3B4252)
            fun `300`() = Color(0xFF4C566A)
        }

        object Greyscale {
            fun `500`() = Color(0xFFECEFF4)
        }

        object Primary {
            fun `600`() = Color(0xFF5E81AC)
            fun `500`() = Color(0xFF81A1C1)
        }
    }

    object Context {
        object Surface {
            val top = Brand.Neutral.`500`()
            val primary = Brand.Primary.`500`()
            val active = Brand.Primary.`600`()
            val contrast: Color = Brand.Greyscale.`500`()
            val base = Brand.Neutral.`600`()
        }
        object Text {
            val primary = Brand.Greyscale.`500`()
            val information = Brand.Neutral.`300`()
            val active = Brand.Primary.`600`()
        }
        object Icon {
            val primary = Brand.Greyscale.`500`()
            val active = Brand.Primary.`600`()
        }
    }
}