package com.hyunny.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkSource(
    val id: String? = null,
    val name: String
)
