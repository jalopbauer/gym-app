package com.indigo.gymapp.common.text

sealed interface TextSize
data object Large : TextSize
data object Medium : TextSize
data object Small : TextSize