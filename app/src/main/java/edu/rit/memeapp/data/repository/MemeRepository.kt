package edu.rit.memeapp.data.repository

import edu.rit.memeapp.data.model.Meme
import edu.rit.memeapp.data.remote.MemeService

class MemeRepository (

private val apiService: MemeService = MemeService.client
) {
    suspend fun getMeme(): Meme = apiService.getMemes()
}
