package com.hyunny.data.datastore

import androidx.datastore.core.DataStore
import com.hyunny.domain.model.UserData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserSettingsDataSource @Inject constructor(
    private val userDataStore: DataStore<UserSettings>
) {

    val userData = userDataStore.data.map {
        UserData(
            followableTopicIds = it.topicsMap.keys.toList()
        )
    }

    suspend fun toggleFlowedTopic(id: Int, followed: Boolean) {
        userDataStore.updateData {
            it.toBuilder().apply {
                if (followed) {
                    putTopics(id, true)
                } else {
                    removeTopics(id)
                }
            }.build()
        }
    }

}
