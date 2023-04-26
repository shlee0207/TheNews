package com.hyunny.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class TopicResponse(
    val id: Int,
    val name: String
)
