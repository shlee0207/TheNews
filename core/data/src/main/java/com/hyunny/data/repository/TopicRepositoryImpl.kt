package com.hyunny.data.repository

import com.hyunny.data.network.TopicApi
import com.hyunny.domain.repository.TopicRepository
import com.hyunny.model.Topic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopicRepositoryImpl @Inject constructor(
    private val topicApi: TopicApi
) : TopicRepository {

    override fun getTopics(): Flow<List<Topic>> = flow {
        emit(
            topicApi.getTopics().map {
                Topic(
                    id = it.id,
                    name = it.name
                )
            }
        )
    }
}
