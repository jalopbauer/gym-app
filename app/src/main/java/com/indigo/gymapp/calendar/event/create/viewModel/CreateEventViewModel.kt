package com.indigo.gymapp.calendar.event.create.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.calendar.event.routine.entity.RoutineEventEntity
import com.indigo.gymapp.calendar.event.routine.entity.RoutineEventFrequencyEntity
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.database.GymDatabase
import com.indigo.gymapp.routines.entity.RoutineEntity
import com.indigo.gymapp.time.Duration
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CreateEventViewModel @Inject constructor(
    @ApplicationContext val context: Context,
) : ViewModel() {

    private val gymDatabase = GymDatabase.getDatabase(context)
    private val routinesDao = gymDatabase.routinesDao()

    private val _selectedRoutine = MutableStateFlow<RoutineEntity?>(null)
    val selectedRoutine = _selectedRoutine.asStateFlow()

    fun setSelectedRoutine(routine: RoutineEntity?) {
        _selectedRoutine.value = routine
    }

    private var _routine = MutableStateFlow(listOf<RoutineEntity>())
    val routines = _routine.asStateFlow()

    private val _selectedDaysOfTheWeek = MutableStateFlow<Set<DayOfTheWeek>>(emptySet())
    val selectedDaysOfTheWeek = _selectedDaysOfTheWeek.asStateFlow()

    fun setSelectedDayOfTheWeek(day: DayOfTheWeek) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val dayOfTheWeeks = selectedDaysOfTheWeek.value
                _selectedDaysOfTheWeek.emit(
                    if (dayOfTheWeeks.contains(day)) {
                        dayOfTheWeeks - day
                    } else {
                        dayOfTheWeeks + day
                    }
                )
            }
        }
    }

    fun searchRoutine(name: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _routine.emit(routinesDao.getRoutinesByName(name))
            }
        }
    }

    private val routinesEventDao = gymDatabase.routinesEventDao()

    suspend fun createRoutineEvent(): Result<Unit> {
        val routineEntity = selectedRoutine.value

        return if (routineEntity == null) {
            Result.failure(MissingRoutine())
        } else {
            withContext(Dispatchers.Default) {
                runCatching {
                    routinesEventDao.create(
                        RoutineEventEntity(
                            routineId = routineEntity.id,
                            estimatedDuration = Duration(
                                hours = 2,
                                minutes = 0,
                            )
                        ),
                        selectedDaysOfTheWeek.value.map {
                            RoutineEventFrequencyEntity(
                                dayOfTheWeek = it
                            )
                        }
                    )
                }
            }
        }
    }
}