package ar.edu.uade.c012026.animeapp.data

import android.util.Log
import ar.edu.uade.c012026.animeapp.data.local.AnimeDatabaseProvider
import ar.edu.uade.c012026.animeapp.data.local.toExternal
import ar.edu.uade.c012026.animeapp.data.local.toLocal
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import okio.IOException
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeApiDataSource: IAnimeDataSource {

    val TAG = "API-DEMO"

    override suspend fun getAnimeList(title: String): List<Anime> {

        Log.d(TAG, "AnimeApiDataSource.getAnimeList")

        return try {
            Log.d(TAG, "AnimeApiDataSource.getAnimeList Search: $title")
            val animeResult = RetrofitInstance.animeAPI.getAnimeList(title)
            Log.d(TAG, "AnimeApiDataSource.getAnimeList Result: ${animeResult.data.size}")
            return animeResult.data
        } catch (e: HttpException) {
            Log.e(TAG, "Error de HTTP: ${e.code()} ${e.message()}")
            emptyList()
        } catch (e: IOException) {
            Log.e(TAG, "Error de Network: ${e.localizedMessage}")
            emptyList()
        } catch (e: Exception) {
            Log.e(TAG, "Error desconocido: ${e.localizedMessage}")
            emptyList()
        }
    }

    override suspend fun getAnimeById(id: Int): Anime {


        val db = FirebaseFirestore.getInstance()
        val dbLocal = AnimeDatabaseProvider.dbLocal

        var animeLocal = dbLocal.animeDao().getAnimeById(id)

        if(animeLocal != null) {
            Log.d(TAG, "LOCAL: ${animeLocal.title}")
            return animeLocal.toExternal()
        }


        val animeResult = db.collection("Favoritos").document(id.toString()).get().await()
        var anime = animeResult.toObject(Anime::class.java);
        if(anime != null) {
            Log.d(TAG, "FIREBASE: ${anime.title}")
            dbLocal.animeDao().insertAnime(anime.toLocal())

            return anime
        };


        anime = RetrofitInstance.animeAPI.getAnimeById(id).data
        Log.d(TAG, "API: ${anime.title}")
        db.collection("Favoritos").document(id.toString()).set(anime);
        dbLocal.animeDao().insertAnime(anime.toLocal())
        return  anime;
    }

}