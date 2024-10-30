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
        }
        object Text {
            val transparent = Brand.transparent
        }
        object Icon {
        }
    }

    object Component {
        @Composable
        fun textFieldColorsField(): TextFieldColors {
            return TextFieldDefaults.colors().copy(
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                cursorColor = MaterialTheme.colorScheme.onSecondary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
                focusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.primary
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
                unselectedColor = MaterialTheme.colorScheme.onPrimary
            )
    }
}