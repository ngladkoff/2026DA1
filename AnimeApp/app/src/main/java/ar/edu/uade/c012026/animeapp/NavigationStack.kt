package ar.edu.uade.c012026.animeapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.uade.c012026.animeapp.components.SplashScreen
import ar.edu.uade.c012026.animeapp.components.animelist.AnimeListScreen


@Composable
fun NavigationStack(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(Screen.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.AnimeList.route){
            AnimeListScreen(navController = navController)
        }
    }
}
