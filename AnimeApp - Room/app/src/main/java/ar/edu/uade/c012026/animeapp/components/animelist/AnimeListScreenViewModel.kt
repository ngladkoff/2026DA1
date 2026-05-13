package ar.edu.uade.c012026.animeapp.components.animelist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012026.animeapp.data.AnimeRepository
import ar.edu.uade.c012026.animeapp.data.AnimeResult
import ar.edu.uade.c012026.animeapp.domain.IAnimeRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okio.IOException

class AnimeListScreenViewModel(
    private val animeRepository: IAnimeRepository = AnimeRepository()
) : ViewModel() {
    var uiState by mutableStateOf(AnimeListScreenState())
        private set

    init {
        getUser();
        fetchAnimes();
    }

    private var fetchJob: Job? = null
    fun fetchAnimes() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState = uiState.copy(animeList = animeRepository.fetchAnimeResults(uiState.searchQuery))
            }catch (e: IOException){
                Log.e("AnimeListScreenViewModel", "Error fetching animes", e)
            }

        }
    }

    fun searChange(value: String) {
        uiState = uiState.copy(searchQuery = value);
    }

    fun getUser(){
        uiState = uiState.copy(userName = FirebaseAuth.getInstance().currentUser?.displayName ?: "Default User")
    }

}