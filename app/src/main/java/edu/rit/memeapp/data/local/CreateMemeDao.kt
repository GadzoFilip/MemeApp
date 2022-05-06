package edu.rit.memeapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.rit.memeapp.data.model.CreateMeme

@Dao
interface CreateMemeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMeme(meme: CreateMeme)

    @Query("SELECT * FROM created_meme_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<CreateMeme>>

}