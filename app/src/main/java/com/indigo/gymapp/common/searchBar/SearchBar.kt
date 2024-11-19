package com.indigo.gymapp.common.searchBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.Search
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.theme.color.Color.Component

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    androidx.compose.material3.SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = onQueryChange,
                onSearch = { },
                expanded = false,
                onExpandedChange = { },
                placeholder = {
                    Title(
                        title = stringResource(R.string.search_exercise),
                        textSize = Medium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                leadingIcon = {
                    Icon(Search)
                },
                trailingIcon = { },
                colors = Component.textFieldColorsField()
            )
        },
        expanded = false,
        onExpandedChange = {},
        colors = Component.searchBarColors(),
    ) {}
}

@Preview
@Composable
private fun EmptySearchBarPreview() {
    SearchBar(
        query = "",
        onQueryChange = {}
    )
}

@Preview
@Composable
private fun FilledSearchBarPreview() {
    SearchBar(
        query = "che",
        onQueryChange = {}
    )
}