package com.hyunny.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkTopic(
    val id: Int,
    val name: String
)
