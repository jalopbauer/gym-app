package com.indigo.gymapp.manager.bottomAppBar

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomAppBarViewModel @Inject constructor(private val bottomAppBarManager: BottomAppBarManagerSingleton) : ViewModel(), BottomAppBarManager {
}