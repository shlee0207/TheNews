package com.hyunny.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.hyunny.data.datastore.UserSettings
import com.hyunny.data.datastore.UserSettingsSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providesUserSettingDataStore(
        @ApplicationContext context: Context,
        userSettingsSerializer: UserSettingsSerializer
    ): DataStore<UserSettings> =
        DataStoreFactory.create(
            userSettingsSerializer
        ) {
            context.dataStoreFile("usersetting.proto")
        }
}
