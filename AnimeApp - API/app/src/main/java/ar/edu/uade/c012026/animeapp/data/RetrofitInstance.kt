package ar.edu.uade.c012026.animeapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val BaseURL = "https://api.jikan.moe/v4/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val animeAPI by lazy {
        retrofit.create(IAnimeAPI::class.java)
    }

}