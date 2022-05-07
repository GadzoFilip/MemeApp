package edu.rit.memeapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.rit.memeapp.data.model.CreateMeme

@Database(entities = [CreateMeme::class], version = 1, exportSchema = false)
abstract class CreatedMemeDatabase: RoomDatabase() {
    abstract fun createdMemeDao(): CreateMemeDao

    companion object {
        @Volatile
        private var instance: CreatedMemeDatabase? = null

        fun getDatabase(context: Context): CreatedMemeDatabase{
            val temp = instance
            if(temp != null){
                return temp
            }
            synchronized(this){
                val instanceRoom = Room.databaseBuilder(
                    context.applicationContext,
                    CreatedMemeDatabase::class.java,
                    "created_meme_database"
                ).build()
                instance = instanceRoom
                return instanceRoom
            }
        }
    }
}