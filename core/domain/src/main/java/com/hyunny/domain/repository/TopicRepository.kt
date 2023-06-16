package com.hyunny.domain.repository

import com.hyunny.model.Topic
import kotlinx.coroutines.flow.Flow

interface TopicRepository {

    fun getTopics(): Flow<List<Topic>>

}
