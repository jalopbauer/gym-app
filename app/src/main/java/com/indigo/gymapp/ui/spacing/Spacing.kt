package com.indigo.gymapp.ui.spacing

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
        }
        object BorderRadious {
            val card = Brand.m
        }
        object BorderStroke {
            val default = Brand.xxs
        }
    }

}