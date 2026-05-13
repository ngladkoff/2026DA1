package ar.edu.uade.c012026.animeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ar.edu.uade.c012026.animeapp.components.NavigationStack
import ar.edu.uade.c012026.animeapp.ui.theme.AnimeAppTheme

class MainActivity : ComponentActivity() {

    override fun onPause() {
        super.onPause()
        Log.d("ANIMEMAIN", "Evento OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ANIMEMAIN", "Evento OnStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d("ANIMEMAIN", "Evento OnStart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("ANIMEMAIN", "Evento OnCreate")

        setContent {
            AnimeAppTheme {
                NavigationStack()
            }
        }
    }
}





