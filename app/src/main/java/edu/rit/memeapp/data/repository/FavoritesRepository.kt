package edu.rit.memeapp.data.repository

import android.content.Context
import androidx.room.Room
import edu.rit.memeapp.data.local.AppDatabase
import edu.rit.memeapp.data.model.MemeInfo

class FavoritesRepository(applicationContext: Context) {

    private val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "meme-db"
    ).build()

    private val memeDao = db.memeDao()

    suspend fun isInFavorites(meme: MemeInfo) = memeDao.getByID(meme.id) != null

    suspend fun getAllMemes() = memeDao.getAll()

    suspend fun add(meme: MemeInfo) = memeDao.insert(meme)

    suspend fun remove(meme: MemeInfo) = memeDao.delete(meme)
}