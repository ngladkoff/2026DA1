package ar.edu.uade.c012026.animeapp

sealed class Screen(val route: String) {
    object AnimeList: Screen("anime_list_screen")
    object Splash: Screen("splash_screen")
}