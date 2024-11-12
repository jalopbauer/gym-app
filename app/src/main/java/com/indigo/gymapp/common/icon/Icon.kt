package com.indigo.gymapp.common.icon

import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.R
import com.indigo.gymapp.ui.spacing.Spacing.Component.Icon

@Composable
fun Icon(iconVariant : IconVariant, tint: Color = MaterialTheme.colorScheme.primary, size: Dp = Icon.size) {
    when (iconVariant) {
        Save -> SaveIcon(tint, size)
        Cancel -> CancelIcon(tint, size)
        Delete -> DeleteIcon(tint, size)
        Edit -> EditIcon(tint, size)
        Add -> AddIcon(tint, size)
        SetRoutineExercise -> SetRoutineExerciseIcon(tint, size)
        TimedRoutineExercise -> TimedRoutineExerciseIcon(tint, size)
        Search -> SearchIcon(tint, size)
        Exercise -> ExerciseIcon(tint, size)
        Calendar -> CalendarIcon(tint, size)
        Routines -> RoutinesIcon(tint, size)
        Configuration -> ConfigurationIcon(tint, size)
    }
}

@Composable
private fun ImageVectorIcon(
    imageVector: ImageVector,
    contentDescription: String,
    tint: Color = MaterialTheme.colorScheme.primary,
    size: Dp = 24.dp,
) {
    androidx.compose.material3.Icon(
        modifier = Modifier.size(size),
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
    size: Dp = 24.dp,
) {
    androidx.compose.material3.Icon(
        modifier = Modifier.size(size),
        painter = painter,
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun CancelIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Close,
        contentDescription = stringResource(R.string.cancel),
        tint = tint,
        size = size,
    )
}

@Composable
fun SaveIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Save,
        contentDescription = stringResource(R.string.save),
        tint = tint,
        size = size,
    )
}

@Composable
fun DeleteIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Delete,
        contentDescription = stringResource(R.string.delete),
        tint = tint,
        size = size,
    )
}

@Composable
fun EditIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Edit,
        contentDescription = stringResource(R.string.edit),
        tint = tint,
        size = size,
    )
}

@Composable
fun AddIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Add,
        contentDescription = stringResource(R.string.add),
        tint = tint,
        size = size,
    )
}

@Composable
fun SetRoutineExerciseIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Replay,
        contentDescription = stringResource(R.string.set),
        tint = tint,
        size = size,
    )
}

@Composable
fun TimedRoutineExerciseIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Timer,
        contentDescription = stringResource(R.string.timed),
        tint = tint,
        size = size,
    )
}

@Composable
fun SearchIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Search,
        contentDescription = stringResource(R.string.search),
        tint = tint,
        size = size,
    )
}

@Composable
fun CalendarIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.CalendarToday,
        contentDescription = stringResource(R.string.calendar),
        tint = tint,
        size = size,
    )
}

@Composable
fun RoutinesIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.AutoMirrored.Outlined.List,
        contentDescription = stringResource(R.string.routines),
        tint = tint,
        size = size,
    )
}

@Composable
fun ConfigurationIcon(tint: Color, size: Dp) {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Settings,
        contentDescription = stringResource(R.string.configuration),
        tint = tint,
        size = size,
    )
}

@Composable
fun ExerciseIcon(tint: Color, size: Dp) {
    PainterIcon(
        painter = painterResource(id = R.drawable.exercise),
        contentDescription = stringResource(R.string.exercise),
        tint = tint,
        size = size,
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
