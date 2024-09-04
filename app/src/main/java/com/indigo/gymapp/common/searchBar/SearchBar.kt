package com.indigo.gymapp.common.searchBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.Search
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.theme.color.Color
import com.indigo.gymapp.ui.theme.color.Color.Component

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
//  https://www.youtube.com/watch?v=90gokceSYdM
    androidx.compose.material3.SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = { },
//  This opens the searchbar garbage that i dont want. soooooooo always faaalse *high pitch*
        active = false,
        onActiveChange = {},
        placeholder = {
            Title(
                title = "Search exercise",
                textSize = Medium,
                color = Color.Context.Text.information
            )
        },
        leadingIcon = {
            Icon(Search)
        },
        colors = Component.searchBarColors()
    ) { }
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