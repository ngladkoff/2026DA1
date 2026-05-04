package ar.edu.uade.c012026.animeapp.domain

import ar.edu.uade.c012026.animeapp.data.Anime

interface IAnimeRepository {
   suspend fun fetchAnimeResults(title: String = ""): List<Anime>
}