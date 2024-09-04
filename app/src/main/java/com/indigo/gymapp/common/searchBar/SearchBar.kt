package com.indigo.gymapp.common.searchBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.Cancel
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.Search
import com.indigo.gymapp.common.text.headline.Headline

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
            Headline("Search exercise")
        },
        leadingIcon = {
            Icon(Search)
        },
        trailingIcon = {
            if (query != "") Icon(Cancel)
        },
        colors = SearchBarDefaults.colors()

    ) { }
}