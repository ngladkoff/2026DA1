package ar.edu.uade.c012026.animeapp.data

interface IAnimeDataSource {
    suspend fun getAnimeList(title: String = ""): List<Anime>
}