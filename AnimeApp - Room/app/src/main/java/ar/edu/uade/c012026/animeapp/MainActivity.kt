package ar.edu.uade.c012026.animeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ar.edu.uade.c012026.animeapp.components.NavigationStack
import ar.edu.uade.c012026.animeapp.components.Screen
import ar.edu.uade.c012026.animeapp.ui.theme.AnimeAppTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.GoogleAuthProvider


class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private lateinit var googleSignInClient: GoogleSignInClient


    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val idToken = account.idToken
            if (idToken != null) {
                val credential = GoogleAuthProvider.getCredential(idToken, null)
                FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener { authResult ->
                        if (authResult.isSuccessful) {
                            navController.navigate(Screen.AnimeList.route) {
                                popUpTo(Screen.Splash.route) {
                                    inclusive = true
                                }
                            }
                        }
                    }
            } else {
                Log.e("ANIMEMAIN", "ID Token is null. Check GoogleSignInOptions configuration.")
            }
        } catch (e: ApiException) {
            Log.d("ANIMEMAIN", "Error de autenticacion: ${e.message}")
        }
    }

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

        // Configure Google Sign-In to request ID token
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        setContent {
            navController = rememberNavController()
            AnimeAppTheme {
                NavigationStack(navController,
                    onGoogleLoginClick = {
                        launcher.launch(googleSignInClient.signInIntent)
                    },
                    onLogoutClick = {
                        FirebaseAuth.getInstance().signOut()
                        navController.navigate(Screen.Login.route) {
                            popUpTo(Screen.AnimeList.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}
