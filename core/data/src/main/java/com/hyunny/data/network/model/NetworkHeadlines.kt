package com.hyunny.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkHeadlines(
    val status: String,
    val totalResults: Int,
    val articles: List<NetworkArticle>
)
