package ar.edu.uade.c012026.animeapp.data

import com.google.gson.annotations.SerializedName

data class AnimesResult(
    val data: List<Anime>
)

data class AnimeResult(
    val data: Anime
)


data class Anime(
    @SerializedName("mal_id")
    val id: Int,
    val title: String,
    val synopsis: String,
    val images: Images
)

data class Images(
    var jpg: ImageJpg

)

data class ImageJpg(
    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("small_image_url")
    val smallImageUrl: String
)


fun emptyAnime(): Anime{
    return Anime(
        id = 0,
        title = "",
        synopsis = "",
        images = Images(
            jpg = ImageJpg(
                imageUrl = "",
                smallImageUrl = ""
            )
        )
    )
}
