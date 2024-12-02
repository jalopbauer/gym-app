package com.indigo.gymapp.navigation

//Routine names must be unique
object NavigationPath {

    data object Exercises : NamedNavigation {
        override val name = "Exercises"
    }

    data object Calendar : NamedNavigation {
        override val name = "Calendar"
    }

    data object Routines : NamedNavigation {
        override val name = "Routines"

        data object Create : NamedNavigation {
            override val name = "${Routines.name}Create"

            data object Exercises : NamedNavigation {
                override val name = "${Routines.Create.name}Exercises"

                data object Create : NamedNavigation {
                    override val name = "${Exercises.name}Creates"
                }
            }
        }
    }

    data object Configuration : NamedNavigation {
        override val name = "Config"
    }
}

sealed interface NamedNavigation {
    val name : String
}