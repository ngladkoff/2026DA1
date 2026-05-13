package ar.edu.uade.c012026.animeapp.components.animedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.edu.uade.c012026.animeapp.components.commons.AnimeUiItemDetail

@Composable
fun AnimeDetailScreen(
    animeId: Int,
    modifier: Modifier = Modifier,
    vm: AnimeDetailScreenViewModel = viewModel()
)
{
    vm.setAnimeId(animeId)

    if (vm.uiState.anime.id == 0) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    else {
        AnimeUiItemDetail(vm.uiState.anime)
    }
}