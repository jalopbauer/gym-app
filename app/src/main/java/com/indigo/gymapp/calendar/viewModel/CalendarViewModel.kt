package com.indigo.gymapp.calendar.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.calendar.day.CalendarDay
import com.indigo.gymapp.calendar.day.NotToday
import com.indigo.gymapp.calendar.day.Today
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.calendar.event.routine.entity.RoutineEventEntity
import com.indigo.gymapp.calendar.event.routine.entity.RoutineEventFrequencyEntity
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.common.daysOfTheWeek.getDayFromInt
import com.indigo.gymapp.common.daysOfTheWeek.today
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
class CalendarViewModel @Inject constructor(
    @ApplicationContext val context: Context,
) : ViewModel() {

    private val gymDatabase = GymDatabase.getDatabase(context)
    private val routinesEventDao = gymDatabase.routinesEventDao()
    private val routinesDao = gymDatabase.routinesDao()

    private fun getCalendarDays() = routinesEventDao
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
        .fold(emptyList<Pair<DayOfTheWeek, RoutineEvent>>()) { acc, event ->
            acc + event.daysOfTheWeek.map { it to event }
        }
        .fold(mapOf<DayOfTheWeek, List<RoutineEvent>>()) {acc, (dayOfTheWeek, event) ->
            acc + (dayOfTheWeek to (acc.getOrDefault(dayOfTheWeek, emptyList()) + event))
        }
        .let {
            (1 until 8)
                .map(::getDayFromInt)
                .map { dayOfTheWeek ->
                    dayOfTheWeek to it.getOrElse(dayOfTheWeek) { emptyList<RoutineEvent>() }
                }
        }
        .fold(Triple(emptyList<CalendarDay>(), emptyList<CalendarDay>(), false)) {
            (beforeToday, afterToday, todayHappened),
            (dayOfTheWeek, routineEvents) ->
            if (today() == dayOfTheWeek) {
                Triple(
                    listOf(
                        Today(
                            routineEvents = routineEvents,
                        )
                    ),
                    afterToday,
                    true
                )
            } else {
                if (todayHappened) {
                    Triple(
                        beforeToday
                        + NotToday(
                            dayOfTheWeek = dayOfTheWeek,
                            routineEvents = routineEvents,
                        ),
                        afterToday,
                        todayHappened)
                } else {
                    Triple(
                        beforeToday,
                        afterToday
                        + NotToday(
                            dayOfTheWeek = dayOfTheWeek,
                            routineEvents = routineEvents,
                        ),
                        todayHappened
                    )
                }
            }
        }.let { (beforeToday, afterToday, _ ) ->
            beforeToday + afterToday
        }

    private val _calendarDays = MutableStateFlow<List<CalendarDay>>(emptyList())
    val calendarDays = _calendarDays.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _calendarDays.value = getCalendarDays()
            }
        }
    }

    suspend fun createExercise(routineEvent: RoutineEvent): Result<Unit> {
        val routineEntity = routinesDao.findById(routineEvent.routineId)
        return if (routineEntity == null) {
            Result.failure(RoutineNotFound())
        } else {
            val routineEventEntity = RoutineEventEntity(
                routineId = routineEntity.id,
                estimatedDuration = routineEvent.estimatedDuration
            )
            val routineEventFrequencyEntities = routineEvent.daysOfTheWeek.map { RoutineEventFrequencyEntity(dayOfTheWeek = it) }
            return withContext(Dispatchers.Default) {
                return@withContext runCatching {
                    routinesEventDao.create(
                        routineEventEntity,
                        routineEventFrequencyEntities
                    )
                }
            }
        }
    }
}