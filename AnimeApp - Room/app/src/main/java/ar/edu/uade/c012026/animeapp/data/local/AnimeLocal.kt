package ar.edu.uade.c012026.animeapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("animes")
data class AnimeLocal(
    @PrimaryKey val id: Int = 0,
    val title: String = "",
    val synopsis: String = "",
    val imageUrl: String = "",
)