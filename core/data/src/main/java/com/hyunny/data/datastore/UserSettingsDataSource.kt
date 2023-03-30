package com.hyunny.data.datastore

import androidx.datastore.core.DataStore
import javax.inject.Inject

class UserSettingsDataSource @Inject constructor(
    private val userDataStore: DataStore<UserSettings>
) {

}
