package com.example.utu.data.model

data class Item(
    val content: String,
    val contentType: String,
    val createAt: Int,
    val creator: Creator,
    val dacAvatar: String,
    val dacName: String,
    val editions: String,
    val eduAvatar: String,
    val eduName: String,
    val feedType: String,
    val images: List<String>,
    val media: Media,
    val name: String,
    val nickName: String,
    val price: String,
    val releasedAt: Int,
    val title: String,
    val type: String,
    val unit: String,
    val video: String,
    val videoLength: Int,
    val videoThumbnail: String,
    val videoTitle: String,
    val views: String
)