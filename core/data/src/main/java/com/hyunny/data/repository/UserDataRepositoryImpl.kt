package com.hyunny.data.repository

import com.hyunny.data.datastore.UserSettingsDataSource
import com.hyunny.domain.repository.UserDataRepository
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userSettingsDataSource: UserSettingsDataSource
): UserDataRepository {


}
