package com.indigo.gymapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.indigo.gymapp.common.bottomAppBar.BottomAppBar
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarManagerSingleton
import com.indigo.gymapp.manager.bottomAppBar.state.Navigation
import com.indigo.gymapp.navigation.NavHostComposable
import com.indigo.gymapp.ui.theme.GymAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var bottomAppBarManagerSingleton : BottomAppBarManagerSingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val bottomAppBarState by bottomAppBarManagerSingleton.bottomAppBarState.collectAsState()

            GymAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            when (bottomAppBarState) {
                                Navigation -> BottomAppBar { navController.navigate(it) }
                            }
                        },
                    ) { innerPadding ->
                        NavHostComposable(innerPadding, navController)
                    }
                }
            }
        }
    }
}