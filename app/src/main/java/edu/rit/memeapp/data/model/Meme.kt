package edu.rit.memeapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meme(
    val data: List<MemeInfo>,
    val next: String,
): Parcelable

@Parcelize
data class MemeInfo(
    val ID: Int,
    val bottomText: String?,
    val image: String?,
    val name: String?,
    val tags: String?,
    val topText: String?,
): Parcelable