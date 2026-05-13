package ar.edu.uade.c012026.animeapp.components.animedetail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012026.animeapp.data.AnimeRepository
import ar.edu.uade.c012026.animeapp.domain.IAnimeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okio.IOException

class AnimeDetailScreenViewModel(
    private val animeRepository: IAnimeRepository = AnimeRepository()
): ViewModel() {
    var uiState by mutableStateOf(AnimeDetailScreenState())
        private set

    fun setAnimeId(id: Int) {
        if(uiState.id == id) return
        uiState = uiState.copy(id = id)
        fetchAnime()
    }

    private var fetchJob: Job? = null

    fun fetchAnime(){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState = uiState.copy(anime = animeRepository.fetchAnimeById(uiState.id))
            }catch (e: IOException){
                Log.e("AnimeListScreenViewModel", "Error fetching animes", e)
            }
        }
    }

}