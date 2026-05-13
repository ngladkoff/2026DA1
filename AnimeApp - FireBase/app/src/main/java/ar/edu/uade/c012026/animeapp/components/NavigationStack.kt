package ar.edu.uade.c012026.animeapp.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.uade.c012026.animeapp.components.animedetail.AnimeDetailScreen
import ar.edu.uade.c012026.animeapp.components.animelist.AnimeListScreen
import ar.edu.uade.c012026.animeapp.components.login.LoginScreen
import ar.edu.uade.c012026.animeapp.components.splash.SplashScreen


@Composable
fun NavigationStack(
    navController: NavHostController = rememberNavController(),
    onGoogleLoginClick: () -> Unit
){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,

    ){
        composable(Screen.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.AnimeList.route){
            AnimeListScreen(navController = navController)
        }
        composable(Screen.AnimeDetail.route + "/{animeId}"){
            var stringId = it.arguments?.getString("animeId")
            var id = stringId?.toInt() ?: 0
            AnimeDetailScreen(id)
        }

        composable(Screen.Login.route){
            LoginScreen(navController = navController,
                onGoogleLoginClick = onGoogleLoginClick)
        }
    }
}
