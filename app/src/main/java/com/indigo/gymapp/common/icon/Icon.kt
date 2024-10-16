package com.indigo.gymapp.common.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Replay
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun Icon(iconVariant : IconVariant) {
    when (iconVariant) {
        Save -> SaveIcon()
        Cancel -> CancelIcon()
        Delete -> DeleteIcon()
        Edit -> EditIcon()
        Add -> AddIcon()
        SetRoutineExercise -> SetRoutineExerciseIcon()
        TimedRoutineExercise -> TimedRoutineExerciseIcon()
        Search -> SearchIcon()
    }
}

@Composable
private fun ImageVectorIcon(
    imageVector: ImageVector,
    contentDescription: String,
) {
    androidx.compose.material3.Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = Color.Context.Icon.primary
    )
}

@Composable
fun CancelIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Close,
        contentDescription = stringResource(R.string.cancel)
    )
}

@Composable
fun SaveIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Save,
        contentDescription = stringResource(R.string.save),
    )
}

@Composable
fun DeleteIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Delete,
        contentDescription = stringResource(R.string.delete),
    )
}

@Composable
fun EditIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Edit,
        contentDescription = stringResource(R.string.edit),
    )
}

@Composable
fun AddIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Add,
        contentDescription = stringResource(R.string.add),
    )
}

@Composable
fun SetRoutineExerciseIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Replay,
        contentDescription = stringResource(R.string.set),
    )
}

@Composable
fun TimedRoutineExerciseIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Timer,
        contentDescription = stringResource(R.string.timed),
    )
}

@Composable
fun SearchIcon() {
    ImageVectorIcon(
        imageVector = Icons.Outlined.Search,
        contentDescription = stringResource(R.string.search),
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
