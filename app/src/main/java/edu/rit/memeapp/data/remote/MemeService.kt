package edu.rit.memeapp.data.remote

import edu.rit.memeapp.data.model.Meme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MemeService {

    @GET("1")
    suspend fun getMemes(): Meme
    companion object {
        private const val baseUrl = "https://alpha-meme-maker.herokuapp.com/"

        val client: MemeService = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MemeService::class.java)
    }
}