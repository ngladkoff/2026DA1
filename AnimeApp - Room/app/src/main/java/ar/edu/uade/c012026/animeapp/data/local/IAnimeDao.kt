package ar.edu.uade.c012026.animeapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface IAnimeDao {
    @Query("SELECT * FROM animes")
    suspend fun getAnimes(): List<AnimeLocal>

    @Query("SELECT * FROM animes WHERE id = :id LIMIT 1")
    suspend fun getAnimeById(id: Int): AnimeLocal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnime(anime: AnimeLocal)

    @Delete
    suspend fun deleteAnime(anime: AnimeLocal)
}
