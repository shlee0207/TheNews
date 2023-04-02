package com.hyunny.data.datastore

import androidx.datastore.core.DataStore
import javax.inject.Inject

class UserSettingsDataSource @Inject constructor(
    private val userDataStore: DataStore<UserSettings>
) {

    suspend fun toggleFlowedTopic(id: String, followed: Boolean) {
        userDataStore.updateData {
            it.toBuilder().apply {
                if (followed) {
                    putTopic(id, true)
                } else {
                    removeTopic(id)
                }
            }.build()
        }
    }
}
