package com.indigo.gymapp.calendar.event.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.database.GymDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RoutineEventsViewModel @Inject constructor(
    @ApplicationContext val context: Context,
) : ViewModel() {

    init {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _routineEvents.value = getRoutineEvents()
            }
        }
    }

    private val gymDatabase = GymDatabase.getDatabase(context)
    private val routinesEventDao = gymDatabase.routinesEventDao()

    private fun getRoutineEvents() = routinesEventDao
        .getAll()
        .map {
            RoutineEvent(
                id = it.routineEventEntity.id,
                routineId = it.routine.id,
                name = it.routine.name,
                estimatedDuration = it.routineEventEntity.estimatedDuration,
                daysOfTheWeek = it.routineEventFrequencyEntities.map { it.dayOfTheWeek }.toSet()
            )
        }

    private val _routineEvents = MutableStateFlow<List<RoutineEvent>>(emptyList())
    val routineEvents = _routineEvents.asStateFlow()

    suspend fun delete(routineEvent: RoutineEvent): Result<Unit> {
        return withContext(Dispatchers.Default) {
            return@withContext runCatching {
                routinesEventDao.deleteById(
                    routineEvent.id
                )
                _routineEvents.value = getRoutineEvents()
            }
        }

    }
}