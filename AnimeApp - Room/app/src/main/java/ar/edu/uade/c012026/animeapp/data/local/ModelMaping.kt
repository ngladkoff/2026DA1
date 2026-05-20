package ar.edu.uade.c012026.animeapp.data.local

import ar.edu.uade.c012026.animeapp.data.Anime
import ar.edu.uade.c012026.animeapp.data.ImageJpg
import ar.edu.uade.c012026.animeapp.data.Images

fun Anime.toLocal() = AnimeLocal(
    id,
    title,
    synopsis,
    images.jpg.imageUrl
)

fun List<Anime>.toLocal() = map(Anime::toLocal)

fun AnimeLocal.toExternal() = Anime(
    id,
    title,
    synopsis,
    Images(ImageJpg(imageUrl, ""))
)

fun List<AnimeLocal>.toExternal() = map(AnimeLocal::toExternal)

