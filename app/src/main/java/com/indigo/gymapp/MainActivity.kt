package com.indigo.gymapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import com.indigo.gymapp.common.bottomAppBar.CreateUpdateDeleteBottomAppBar
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarManagerSingleton
import com.indigo.gymapp.manager.bottomAppBar.state.CreateUpdateDelete
import com.indigo.gymapp.manager.bottomAppBar.state.Empty
import com.indigo.gymapp.manager.bottomAppBar.state.Navigation
import com.indigo.gymapp.navigation.BottomAppBar
import com.indigo.gymapp.navigation.NavHostComposable
import com.indigo.gymapp.security.biometrics.BiometricAuthManager
import com.indigo.gymapp.ui.theme.GymAppTheme
import com.indigo.gymapp.ui.theme.color.Color
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject
    lateinit var bottomAppBarManagerSingleton: BottomAppBarManagerSingleton

    @Inject
    lateinit var biometricAuthManager: BiometricAuthManager

    private var isAuthenticated by mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val bottomAppBarState by bottomAppBarManagerSingleton.bottomAppBarState.collectAsState()

            if (!isAuthenticated) {
                biometricAuthManager.authenticate(
                    context = this,
                    onError = {
                        Toast.makeText(this, "Authentication error", Toast.LENGTH_LONG).show()
                        isAuthenticated = false
                    },
                    onSuccess = {
                        Toast.makeText(this, "Authentication successful", Toast.LENGTH_LONG).show()
                        isAuthenticated = true
                    },
                    onFail = {
                        Toast.makeText(this, "Authentication failed", Toast.LENGTH_LONG).show()
                        isAuthenticated = false
                    }
                )
            }

            GymAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Context.Surface.base
                ) {
                    if (isAuthenticated) {
                        Scaffold(
                            bottomBar = {
//                              bottomAppBarState is set to a variable as to be able to smart cast
                                when (val state = bottomAppBarState) {
                                    is Navigation -> BottomAppBar(
                                        initialItem = state.item,
                                        onNavigate = { navController.navigate(it) }
                                    )
                                    is CreateUpdateDelete -> CreateUpdateDeleteBottomAppBar(
                                        state.isDeleteEnabled,
                                        state.isEditEnabled,
                                        state.addOnClick,
                                        state.editOnClick,
                                        state.deleteOnClick
                                    )
                                    Empty -> {}
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
}
