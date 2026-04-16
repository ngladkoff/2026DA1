package ar.edu.uade.c012026.animeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ar.edu.uade.c012026.animeapp.ui.theme.AnimeAppTheme
import ar.edu.uade.c012026.animeapp.components.animelist.AnimeListScreen
import com.google.gson.Gson

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
                AnimeListScreen()
            }
        }
    }
}





