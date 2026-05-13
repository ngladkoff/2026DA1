package ar.edu.uade.c012026.animeapp.components

sealed class Screen(val route: String) {
    object AnimeList: Screen("anime_list_screen")
    object Splash: Screen("splash_screen")
    object AnimeDetail: Screen("anime_detail_screen")
}