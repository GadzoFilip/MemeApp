package edu.rit.memeapp.data.repository

import androidx.lifecycle.LiveData
import edu.rit.memeapp.data.local.CreateMemeDao
import edu.rit.memeapp.data.model.CreateMeme

class CreatedMemeRepository(private val createdMemeDao: CreateMemeDao) {

    val readAllData: LiveData<List<CreateMeme>> = createdMemeDao.readAllData()

    suspend fun addMeme(meme: CreateMeme) {
        createdMemeDao.addMeme(meme)
    }
}