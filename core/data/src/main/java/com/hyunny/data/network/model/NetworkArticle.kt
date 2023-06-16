package com.hyunny.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkArticle(
    val source: NetworkSource,
    val author: String? = null,
    val title: String,
    val description: String = "",
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String = ""
)
