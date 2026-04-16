package ar.edu.uade.c012026.animeapp.components.animelist

import ar.edu.uade.c012026.animeapp.Anime

data class AnimeListScreenState(
    val animeList: List<Anime> = emptyList(),
    val searchQuery: String = ""
)