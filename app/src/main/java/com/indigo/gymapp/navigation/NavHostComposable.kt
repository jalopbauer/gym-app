package com.indigo.gymapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.indigo.gymapp.pages.calendar.Calendar
import com.indigo.gymapp.pages.configuration.Configuration
import com.indigo.gymapp.pages.exercises.Exercises
import com.indigo.gymapp.pages.routines.Routines
import com.indigo.gymapp.pages.routines.create.CreateRoutine
import com.indigo.gymapp.pages.routines.create.exercise.create.CreateRoutineExercise
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun NavHostComposable(innerPadding: PaddingValues, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.Calendar.name,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Context.Surface.base)
            .padding(innerPadding)
            .padding(horizontal = 10.dp)
    ) {
//        Exercises
        composable(route = NavigationPath.Exercises.name) {
            Exercises()
        }
//        Calendar
        composable(route = NavigationPath.Calendar.name) {
            Calendar()
        }
//        Routines
        composable(route = NavigationPath.Routines.name) {
            Routines(
                onNavigateToCreateRoutine = { navController.navigate( NavigationPath.Routines.Create.name )}
            )
        }
        composable(route = NavigationPath.Routines.Create.name) {
            CreateRoutine(
                onNavigateToRoutines = { navController.navigate( NavigationPath.Routines.Create.name ) },
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
            Configuration()
        }
        
    }
}
