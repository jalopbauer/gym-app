package com.indigo.gymapp.ui.spacing

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

object Spacing {

    private object Brand {
        val xxs = 2.dp
        val xs = 4.dp
        val s = 8.dp
        val m = 16.dp
        val l = 24.dp
        val xl = 32.dp
        val xxl = 40.dp
    }

    object Context {
        object Padding {
            val screen = Brand.l
            val header_with_icon_button = Brand.m
            val card = Brand.m
            val button = Brand.m
        }
        object Gap {
            val space = Brand.xs
            val default = Brand.s
            val medium = Brand.m
            val extra_large = Brand.xl
            val circle_button = Brand.xl
        }
        object BorderRadious {
            val card = Brand.m
        }
        object BorderStroke {
            val default = Brand.xxs
        }
        object Spacer {
            val listBottom = 64.dp
        }
    }

    object Component {
        object NumberScroll {
            val pageSize = 64.dp
            val verticalPagerHeight = 360.dp
            val verticalPaddingValues = PaddingValues(vertical = (verticalPagerHeight - pageSize) / 2)
            val horizontalPaddingValues = PaddingValues(horizontal = pageSize * 2 + pageSize / 4)
        }

        object Icon {
            object Descriptor {
                val size = 16.dp
            }
        }
    }

}