package com.hyunny.domain.usecase

import com.hyunny.domain.model.FollowableTopic
import com.hyunny.domain.repository.TopicRepository
import com.hyunny.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetFollowableTopicUseCase @Inject constructor(
    private val topicRepository: TopicRepository,
    private val userDataRepository: UserDataRepository
) {

    operator fun invoke(): Flow<List<FollowableTopic>> {
        return combine(
            userDataRepository.userData,
            topicRepository.getTopics()
        ) { userData, topics ->
            topics.map { topic ->
                FollowableTopic(
                    topic = topic,
                    isFollowed = userData.followableTopicIds.contains(topic.id)
                )
            }
        }
    }
}
