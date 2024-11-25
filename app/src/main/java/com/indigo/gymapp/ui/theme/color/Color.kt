package com.indigo.gymapp.ui.theme.color

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Suppress("FunctionName")
object Color {

    object Theme {

        object Nord {
            fun `neutral-600`(): Color = Color(0xFF2E3440)
            fun `neutral-500`(): Color = Color(0xFF3B4252)
            fun `neutral-300`(): Color = Color(0xFF4C566A)
            fun `neutral-200`(): Color = Color(0xFF8893AA)

            fun `greyscale-700`(): Color = Color(0xFFd8dee9)
            fun `greyscale-500`(): Color = Color(0xFFECEFF4)

            fun `primary-600`(): Color = Color(0xFF5E81AC)
            fun `primary-500`(): Color = Color(0xFF81A1C1)

            fun `state-error`(): Color = Color(0xFFbf616a)
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
        )

        @Composable
        fun radioButtonColors() =
            RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.secondary,
                unselectedColor = MaterialTheme.colorScheme.onPrimary
            )

        @Composable
        fun navigationBarItemColors() =
            NavigationBarItemDefaults.colors(
                indicatorColor = MaterialTheme.colorScheme.background
            )

        object Button {
            @Composable
            fun primaryButtonColor() =
                ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.secondary
                )

            @Composable
            fun dangerButtonColor() =
                ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.error
                )

            @Composable
            fun secondaryButtonColor() =
                ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.background,
                )

            @Composable
            fun circleButtonColor() =
                ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
        }
    }
}