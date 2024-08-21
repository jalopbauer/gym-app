package com.indigo.gymapp.navigation

object NavigationPath {

    data object Exercises : NamedNavigation {
        override val name = "Exercises"
    }

    data object Calendar : NamedNavigation {
        override val name = "Calendar"
    }

    data object Routines : NamedNavigation {
        override val name = "Routines"
    }

    data object Configuration : NamedNavigation {
        override val name = "Config"
    }
}

sealed interface NamedNavigation {
    val name : String
}