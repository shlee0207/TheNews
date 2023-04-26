package com.hyunny.data.network

import android.content.Context
import com.hyunny.data.network.model.TopicResponse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class FakeTopicApi(
    private val context: Context
) : TopicApi {

    companion object {
        private const val TOPICS_ASSET = "topics.json"
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getTopics(): List<TopicResponse> {
        return context.assets.open(TOPICS_ASSET).use(Json::decodeFromStream)
    }
}
