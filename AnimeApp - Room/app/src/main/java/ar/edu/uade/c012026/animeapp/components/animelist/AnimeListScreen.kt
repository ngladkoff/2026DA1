package ar.edu.uade.c012026.animeapp.components.animelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012026.animeapp.components.Screen
import ar.edu.uade.c012026.animeapp.components.commons.AnimeUIList

@Composable
fun AnimeListScreen(
    modifier: Modifier = Modifier,
    vm: AnimeListScreenViewModel = viewModel(),
    navController: NavHostController,
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Row( modifier= Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Bienvenido ${vm.uiState.userName}",
            )
            Button(onClick = onLogoutClick) {
                Text("Cerrar Sesión")
            }
        }
        Text(
            text = "Listado de Anime",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
        )
        Row( modifier= Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = vm.uiState.searchQuery,
                modifier= Modifier.weight(1f),
                label = { Text("Buscar anime: ") },
                singleLine = true,
                onValueChange = {
                   vm.searChange(it);
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { vm.fetchAnimes() }) {
                Text("Buscar")
            }

        }
        Spacer(modifier = Modifier.height(12.dp))
        AnimeUIList(vm.uiState.animeList, Modifier.fillMaxSize(), onAnimeClick = { id ->
            navController.navigate(Screen.AnimeDetail.route + "/$id")}
        )
    }
}

