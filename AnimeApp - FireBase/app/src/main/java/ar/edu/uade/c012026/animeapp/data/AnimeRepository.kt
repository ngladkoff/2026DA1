package ar.edu.uade.c012026.animeapp.data

import android.R
import ar.edu.uade.c012026.animeapp.domain.IAnimeRepository

class AnimeRepository (
val animeDataSource: IAnimeDataSource = AnimeApiDataSource()
): IAnimeRepository {

    override suspend fun fetchAnimeResults(title: String): List<Anime> {
        return animeDataSource.getAnimeList(title)
    }

    override suspend fun fetchAnimeById(id: Int): Anime {
        return animeDataSource.getAnimeById(id)
    }

}