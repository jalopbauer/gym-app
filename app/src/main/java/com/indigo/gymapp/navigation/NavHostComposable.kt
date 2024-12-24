package com.indigo.gymapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.indigo.gymapp.calendar.CalendarPage
import com.indigo.gymapp.calendar.event.RoutineEventsPage
import com.indigo.gymapp.calendar.event.create.CreateEventPage
import com.indigo.gymapp.configuration.ConfigurationPage
import com.indigo.gymapp.exercises.ExercisesPage
import com.indigo.gymapp.routines.RoutinesPage
import com.indigo.gymapp.routines.create.CreateRoutine
import com.indigo.gymapp.routines.exercises.create.CreateRoutineExercise

@Composable
fun NavHostComposable(innerPadding: PaddingValues, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.Calendar.name,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(innerPadding)
    ) {
//        Exercises
        composable(route = NavigationPath.Exercises.name) {
            ExercisesPage()
        }
//        Calendar
        composable(route = NavigationPath.Calendar.name) {
            CalendarPage(
                onNavigateToCreateEvent = { navController.navigate(NavigationPath.Calendar.Event.Create.name) },
                onNavigateToEditEvents = { navController.navigate(NavigationPath.Calendar.Event.name) },
            )
        }
        composable(route = NavigationPath.Calendar.Event.Create.name) {
            CreateEventPage(
                onNavigateToCalendar = { navController.navigate( NavigationPath.Calendar.name )}
            )
        }
        composable(route = NavigationPath.Calendar.Event.name) {
            RoutineEventsPage(
                onNavigateToCreateEvent = { navController.navigate( NavigationPath.Calendar.Event.Create.name )}
            )
        }
//        Routines
        composable(route = NavigationPath.Routines.name) {
            RoutinesPage(
                onNavigateToCreateRoutine = { navController.navigate( NavigationPath.Routines.Create.name )}
            )
        }
        composable(route = NavigationPath.Routines.Create.name) {
            CreateRoutine(
                onNavigateToRoutines = { navController.navigate( NavigationPath.Routines.name ) },
                onNavigateToAddRoutineExercise = { navController.navigate( NavigationPath.Routines.Create.Exercises.Create.name ) }
            )
        }
        composable(route = NavigationPath.Routines.Create.Exercises.Create.name) {
            CreateRoutineExercise(
                onNavigateToCreateRoutine = { navController.navigate( NavigationPath.Routines.Create.name ) },
            )
        }
//        Configuration
        composable(route = NavigationPath.Configuration.name) {
            ConfigurationPage()
        }
        
    }
}
