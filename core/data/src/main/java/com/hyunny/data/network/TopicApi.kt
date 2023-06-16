package com.hyunny.data.network

import com.hyunny.data.network.model.NetworkTopic

interface TopicApi {

    suspend fun getTopics(): List<NetworkTopic>

}
