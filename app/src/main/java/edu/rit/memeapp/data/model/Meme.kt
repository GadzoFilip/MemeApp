package edu.rit.memeapp.data.model

data class Meme(
    val data: MemeInfo,
    val next: String,
)

data class MemeInfo(
    val ID: Int,
    val bottomText: String?,
    val image: String?,
    val name: String?,
    val tags: String?,
    val topText: String?,
)