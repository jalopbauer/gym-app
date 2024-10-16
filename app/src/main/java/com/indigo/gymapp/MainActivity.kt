package com.indigo.gymapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import com.indigo.gymapp.common.bottomAppBar.BottomAppBar
import com.indigo.gymapp.common.bottomAppBar.CreateUpdateDeleteBottomAppBar
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarManagerSingleton
import com.indigo.gymapp.manager.bottomAppBar.state.CreateUpdateDelete
import com.indigo.gymapp.manager.bottomAppBar.state.Empty
import com.indigo.gymapp.manager.bottomAppBar.state.Navigation
import com.indigo.gymapp.navigation.NavHostComposable
import com.indigo.gymapp.security.biometrics.BiometricAuthManager
import com.indigo.gymapp.ui.theme.GymAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject
    lateinit var bottomAppBarManagerSingleton: BottomAppBarManagerSingleton

    @Inject
    lateinit var biometricAuthManager: BiometricAuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {

            var isAuthenticated by remember { mutableStateOf(false) }
            // Call biometric authentication when the activity is created
            biometricAuthManager.authenticate(
                context = this,
                onError = {
                    // Handle the authentication error
                    Toast.makeText(this, "d", Toast.LENGTH_LONG).show()
                    isAuthenticated = false
                },
                onSuccess = {
                    // Handle successful authentication
                    Toast.makeText(this, "dd", Toast.LENGTH_LONG).show()
                    isAuthenticated = true
                },
                onFail = {
                    // Handle failed authentication
                    Toast.makeText(this, "ddd", Toast.LENGTH_LONG).show()
                    isAuthenticated = false
                }
            )
            val navController = rememberNavController()
            val bottomAppBarState by bottomAppBarManagerSingleton.bottomAppBarState.collectAsState()

            val biometricManager = remember { BiometricManager.from(this) }
            val isBiometricAvailable = remember {
                biometricManager.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
            }
            when (isBiometricAvailable) {
                BiometricManager.BIOMETRIC_SUCCESS -> {
                    // Biometric features are available
                    if (isAuthenticated) {
                        GymAppTheme {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                            ) {
                                Scaffold(
                                    bottomBar = {
//                            bottomAppBarState is set to a variable as to be able to smart cast
                                        when (val state = bottomAppBarState) {
                                            is Navigation -> BottomAppBar(
                                                initialItem = state.item,
                                                onNavigate = { navController.navigate(it) }
                                            )
                                            is CreateUpdateDelete -> {
                                                CreateUpdateDeleteBottomAppBar(
                                                    state.isDeleteEnabled,
                                                    state.isEditEnabled,
                                                    state.addOnClick,
                                                    state.editOnClick,
                                                    state.deleteOnClick,
                                                )
                                            }
                                            Empty -> {}
                                        }
                                    },
                                ) { innerPadding ->
                                    NavHostComposable(innerPadding, navController)
                                }
                            }
                        }
                    } else {
                        Text(text = "You need to authenticate")
                    }
                }

                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                    // No biometric features available on this device
                    Text(text = "This phone is not prepared for biometric features")
                }

                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                    // Biometric features are currently unavailable.
                    Text(text = "Biometric auth is unavailable")
                }

                BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
                    // Biometric features available but a security vulnerability has been discovered
                    Text(text = "You can't use biometric auth until you have updated your security details")
                }

                BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
                    // Biometric features are currently unavailable because the specified options are incompatible with the current Android version..
                    Text(text = "You can't use biometric auth with this Android version")
                }

                BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
                    // Unable to determine whether the user can authenticate using biometrics
                    Text(text = "You can't use biometric auth")
                }

                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                    // The user can't authenticate because no biometric or device credential is enrolled.
                    Text(text = "You can't use biometric auth")
                }
            }
        }
    }
}
