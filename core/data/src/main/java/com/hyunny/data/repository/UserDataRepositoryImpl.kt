package com.hyunny.data.repository

import com.hyunny.data.datastore.UserSettingsDataSource
import com.hyunny.domain.model.UserData
import com.hyunny.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userSettingsDataSource: UserSettingsDataSource
): UserDataRepository {

    override val userData: Flow<UserData> = userSettingsDataSource.userData

    override suspend fun toggleFollowedTopic(id: Int, followed: Boolean) {
        userSettingsDataSource.toggleFlowedTopic(id, followed)
    }
}
