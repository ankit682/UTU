package com.example.utu.data.model

data class Toppost(
    val content: String,
    val createAt: Int,
    val dacAvatar: String,
    val dacName: String,
    val feedType: String,
    val images: List<String>,
    val nickName: String,
    val video: String,
    val videoLength: Int,
    val videoThumbnail: String,
    val videoTitle: String,
    val views: String
)