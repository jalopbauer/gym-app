package com.indigo.gymapp.common.searchList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.searchBar.SearchBar
import com.indigo.gymapp.common.searchList.item.SearchListItem
import com.indigo.gymapp.ui.number.Number.Context.Gap


@Composable
fun <T> SearchList(
    query: String,
    placeholder: String,
    items: List<T>,
    text : (T) -> String,
    onQueryChange: (String) -> Unit,
    getItemOnClick: (T) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxHeight(0.5f),
        verticalArrangement = Arrangement.spacedBy(Gap.default)
    ) {
        SearchBar(
            placeholder = placeholder,
            query = query,
            onQueryChange = onQueryChange
        )
        LazyColumn {
            items(items) { item ->
                SearchListItem(
                    item = item,
                    text = text,
                    getItemOnClick = getItemOnClick
                )
            }
        }
    }
}