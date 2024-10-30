package com.indigo.gymapp.ui.theme.color

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Color {
    private object Brand : ColorTheme {
        val theme : ColorTheme = NordDark
        override val transparent: Color = theme.transparent
        override fun `neutral-600`(): Color = theme.`neutral-600`()
        override fun `neutral-500`(): Color = theme.`neutral-500`()
        override fun `neutral-300`(): Color = theme.`neutral-300`()
        override fun `greyscale-500`(): Color = theme.`greyscale-500`()
        override fun `primary-600`(): Color = theme.`primary-600`()
        override fun `primary-500`(): Color = theme.`primary-500`()
    }

    object Context {
        object Surface {
            val active = Brand.`primary-600`()
            val contrast: Color = Brand.`greyscale-500`()
            val base = Brand.`neutral-600`()
            val information = Brand.`neutral-300`()
        }
        object Text {
            val primary = Brand.`greyscale-500`()
            val information = Brand.`neutral-300`()
            val active = Brand.`primary-600`()
            val transparent = Brand.transparent
        }
        object Icon {
            val primary = Brand.`greyscale-500`()
            val active = Brand.`primary-600`()
        }
    }

    object Component {
        @Composable
        fun textFieldColorsField(): TextFieldColors {
            return TextFieldDefaults.colors().copy(
                unfocusedContainerColor = Context.Surface.base,
                focusedContainerColor = Context.Surface.base,
                cursorColor = Context.Icon.active,
                unfocusedIndicatorColor = Context.Surface.base,
                focusedIndicatorColor = Context.Icon.active,
                focusedTextColor = Context.Text.primary,
                unfocusedTextColor = Context.Text.primary
            )
        }
        @Composable
        @OptIn(ExperimentalMaterial3Api::class)
        fun searchBarColors() = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface,
            dividerColor = MaterialTheme.colorScheme.surface,
            inputFieldColors = textFieldColorsField(),
        )
        @Composable
        fun radioButtonColors() =
            RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.secondary,
                unselectedColor = Context.Surface.information
            )
    }
}