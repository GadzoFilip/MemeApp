package edu.rit.memeapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Meme (
    val data: List<MemeInfo>,
    val next: String,
): Parcelable

@Entity
@Parcelize
data class MemeInfo(
    @PrimaryKey
    @SerializedName("ID")
    val id: Int,
    val bottomText: String?,
    val image: String?,
    val name: String?,
    val tags: String?,
    val topText: String?,
): Parcelable