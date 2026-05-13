package ar.edu.uade.c012026.animeapp.components.animelist

import ar.edu.uade.c012026.animeapp.data.Anime

data class AnimeListScreenState(
    val userName: String = "Defaul User",
    val animeList: List<Anime> = emptyList(),
    val searchQuery: String = ""
)