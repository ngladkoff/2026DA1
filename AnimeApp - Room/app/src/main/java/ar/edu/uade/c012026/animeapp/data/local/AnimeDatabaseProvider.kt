package ar.edu.uade.c012026.animeapp.data.local

import android.content.Context

object AnimeDatabaseProvider{
    lateinit var dbLocal: AnimeDatabase
        private set

    fun createDatabase(context: Context){
        dbLocal = AnimeDatabase.getInstance(context)
    }
}