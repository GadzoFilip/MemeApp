package edu.rit.memeapp.data.local


import androidx.room.*

import edu.rit.memeapp.data.model.MemeInfo

@Dao
interface MemeDao {
    @Query("SELECT * FROM memeinfo")
    suspend fun getAll(): List<MemeInfo>

    @Query("SELECT * FROM memeInfo WHERE id = :id LIMIT 1")
    suspend fun getByID(id: Int): MemeInfo?

    @Insert
    suspend fun insert(meme: MemeInfo)

    @Delete
    suspend fun delete(meme: MemeInfo)
}


@Database(entities = [MemeInfo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun memeDao(): MemeDao
}