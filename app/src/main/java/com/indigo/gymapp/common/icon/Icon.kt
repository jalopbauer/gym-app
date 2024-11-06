package com.indigo.gymapp.common.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Replay
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R

@Composable
fun Icon(iconVariant : IconVariant, tint: Color = MaterialTheme.colorScheme.primary) {
    when (iconVariant) {
        Save -> SaveIcon(tint)
        Cancel -> CancelIcon(tint)
        Delete -> DeleteIcon(tint)
        Edit -> EditIcon(tint)
        Add -> AddIcon(tint)
        SetRoutineExercise -> SetRoutineExerciseIcon(tint)
        TimedRoutineExercise -> TimedRoutineExerciseIcon(tint)
        Search -> SearchIcon(tint)
        Exercise -> ExerciseIcon(tint)
        Calendar -> CalendarIcon(tint)
        Routines -> RoutinesIcon(tint)
        Configuration -> ConfigurationIcon(tint)
    }
}

@Composable
private fun ImageVectorIcon(
    imageVector: ImageVector,
    contentDescription: String,
    tint: Color = MaterialTheme.colorScheme.primary,
) {
    androidx.compose.material3.Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
private fun PainterIcon(
    painter: Painter,
    contentDescription: String,
    tint: Color = MaterialTheme.colorScheme.primary,
) {
    androidx.compose.material3.Icon(
        painter = painter,
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun CancelIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Close,
        contentDescription = stringResource(R.string.cancel),
        tint = tint
    )
}

@Composable
fun SaveIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Save,
        contentDescription = stringResource(R.string.save),
        tint = tint
    )
}

@Composable
fun DeleteIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Delete,
        contentDescription = stringResource(R.string.delete),
        tint = tint
    )
}

@Composable
fun EditIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Edit,
        contentDescription = stringResource(R.string.edit),
        tint = tint
    )
}

@Composable
fun AddIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Add,
        contentDescription = stringResource(R.string.add),
        tint = tint
    )
}

@Composable
fun SetRoutineExerciseIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Replay,
        contentDescription = stringResource(R.string.set),
        tint = tint
    )
}

@Composable
fun TimedRoutineExerciseIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Timer,
        contentDescription = stringResource(R.string.timed),
        tint = tint
    )
}

@Composable
fun SearchIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Search,
        contentDescription = stringResource(R.string.search),
        tint = tint
    )
}

@Composable
fun CalendarIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.CalendarToday,
        contentDescription = stringResource(R.string.calendar),
        tint = tint
    )
}

@Composable
fun RoutinesIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.AutoMirrored.Outlined.List,
        contentDescription = stringResource(R.string.routines),
        tint = tint
    )
}

@Composable
fun ConfigurationIcon(tint: Color) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Settings,
        contentDescription = stringResource(R.string.configuration),
        tint = tint
    )
}

@Composable
fun ExerciseIcon(tint: Color) {
    PainterIcon(
        painter = painterResource(id = R.drawable.exercise),
        contentDescription = stringResource(R.string.exercise),
        tint = tint
    )
}

sealed interface IconVariant

data object Save : IconVariant

data object Cancel : IconVariant

data object Delete : IconVariant

data object Edit : IconVariant

data object Add : IconVariant

data object SetRoutineExercise : IconVariant

data object TimedRoutineExercise : IconVariant

data object Search : IconVariant

data object Exercise : IconVariant

data object Calendar : IconVariant

data object Routines : IconVariant

data object Configuration : IconVariant
