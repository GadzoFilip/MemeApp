package edu.rit.memeapp.data.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "created_meme_table")
data class CreateMeme (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val topText: String,
    val bottomText: String,
    val name: String,
//    val image: Bitmap
)