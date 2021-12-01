package com.example.utu.data.model

data class Nfttip(
    val creator: Creator,
    val dacName: String,
    val editions: String,
    val feedType: String,
    val media: Media,
    val name: String,
    val price: String,
    val releasedAt: Int,
    val type: String,
    val unit: String
)