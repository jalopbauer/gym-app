package com.indigo.gymapp.ui.theme.color

import androidx.compose.ui.graphics.Color

object Color {
    private object Brand {
        object Neutral {
            fun `600`() = Color(0xFF2E3440)
            fun `300`() = Color(0xFF4C566A)
        }

        object Greyscale {
            fun `500`() = Color(0xFFECEFF4)
        }
    }

    object Context {
        object Surface {
            val contrast: Color = Brand.Greyscale.`500`()
            val base = Brand.Neutral.`600`()
        }
        object Text {
            val primary = Brand.Greyscale.`500`()
            val information = Brand.Neutral.`300`()
        }
        object Icon {
            val primary = Brand.Greyscale.`500`()
        }
    }
}