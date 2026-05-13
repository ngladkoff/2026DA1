package ar.edu.uade.c012026.animeapp.components.animedetail

import ar.edu.uade.c012026.animeapp.data.Anime
import ar.edu.uade.c012026.animeapp.data.emptyAnime

data class AnimeDetailScreenState(
    val id: Int = 0,
    val anime: Anime = emptyAnime()
)
