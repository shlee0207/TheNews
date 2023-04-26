package com.hyunny.domain.repository

import com.hyunny.domain.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserData>

    suspend fun toggleFollowedTopic(id: Int, followed: Boolean)

}
