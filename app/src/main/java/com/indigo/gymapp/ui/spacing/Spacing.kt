package com.indigo.gymapp.ui.spacing

import androidx.compose.ui.unit.dp

object Spacing {

    private object Brand {
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
        }
        object Gap {
            val default = Brand.s
        }
    }

}