package ar.edu.uade.c012026.animeapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AnimeLocal::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {
            abstract fun animeDao(): IAnimeDao

            companion object {
                @Volatile
                private var _instance: AnimeDatabase? = null

                fun getInstance(context: Context): AnimeDatabase = _instance ?: synchronized(this) {
                    _instance ?: buildDatabase(context)
                }

                private fun buildDatabase(context: Context): AnimeDatabase =
                    Room.databaseBuilder(context, AnimeDatabase::class.java, "anime_database")
                        .fallbackToDestructiveMigration()
                        .build()



            }

}
