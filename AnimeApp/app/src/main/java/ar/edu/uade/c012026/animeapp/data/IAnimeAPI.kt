package ar.edu.uade.c012026.animeapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface IAnimeAPI {


    @GET("anime")
    suspend fun getAnimeList(
        @Query("q") title: String
    ): AnimeResult

}