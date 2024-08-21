package com.indigo.gymapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.indigo.gymapp.calendar.Calendar
import com.indigo.gymapp.configuration.Configuration
import com.indigo.gymapp.exercises.Exercises
import com.indigo.gymapp.routines.Routines

@Composable
fun NavHostComposable(innerPadding: PaddingValues, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.Calendar.name,
        modifier = Modifier
            .fillMaxSize()
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
            Routines()
        }
//        Configuration
        composable(route = NavigationPath.Configuration.name) {
            Configuration()
        }
        
    }
}
