package ar.edu.uade.c012026.animeapp.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ar.edu.uade.c012026.animeapp.Anime

@Composable
fun AnimeUIList(animeList: List<Anime>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(
            items = animeList,
            key = { it -> it.id}
        ) {
                anime -> AnimeUIItem(anime)
        }
    }
}

