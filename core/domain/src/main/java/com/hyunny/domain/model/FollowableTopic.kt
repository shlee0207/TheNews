package com.hyunny.domain.model

import com.hyunny.model.Topic

data class FollowableTopic(
    val topic: Topic,
    val isFollowed: Boolean,
)
