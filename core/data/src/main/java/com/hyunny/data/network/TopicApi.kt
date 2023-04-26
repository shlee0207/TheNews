package com.hyunny.data.network

import com.hyunny.data.network.model.TopicResponse

interface TopicApi {

    suspend fun getTopics(): List<TopicResponse>
}
