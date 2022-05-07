package edu.rit.memeapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.rit.memeapp.data.model.CreateMeme
import retrofit2.http.DELETE

@Dao
interface CreateMemeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMeme(meme: CreateMeme)

    @Query("SELECT * FROM created_meme_table ORDER BY id ASC")
    fun readData(): LiveData<List<CreateMeme>>

    @Delete
    suspend fun deleteMeme(meme: CreateMeme)

}