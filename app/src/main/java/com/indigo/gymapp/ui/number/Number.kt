package com.indigo.gymapp.ui.number

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

object Number {

    private object Brand {
        val xxs = 2.dp
        val xs = 4.dp
        val s = 8.dp
        val m = 16.dp
        val l = 24.dp
        val xl = 32.dp
    }

    object Context {
        object Padding {
            val screen = Brand.l
            val card = Brand.m
            val button = Brand.m
        }
        object Gap {
            val space = Brand.xs
            val default = Brand.s
            val medium = Brand.m
            val extraLarge = Brand.xl
            val circleButton = Brand.xl
        }
        object BorderRadius {
            val card = Brand.m
        }
        object BorderStroke {
            val default = Brand.xxs
        }
    }

    object Component {
        object Spacer {
            val listBottom = 64.dp
        }

        object Header {
            object CreateHeader {
                val horizontalPadding = Brand.m
            }
        }
        object NumberScroll {
            val pageSize = 64.dp
            val verticalPagerHeight = 360.dp
            val verticalPaddingValues = PaddingValues(vertical = (verticalPagerHeight - pageSize) / 2)
            val horizontalPaddingValues = PaddingValues(horizontal = pageSize * 2 + pageSize / 4)
        }

        object Icon {
            val descriptor = 16.dp
            val default = 24.dp
            val highlight = 32.dp
        }

        object Button {
            val minimumHeight = 48.dp
            object CircleButton {
                val diameter = 69.dp
                val padding = 0.dp
            }
        }
    }

}