package com.hyunny.domain.repository

interface UserDataRepository {

    suspend fun toggleFollowedTopic(id: String, followed: Boolean)
}
