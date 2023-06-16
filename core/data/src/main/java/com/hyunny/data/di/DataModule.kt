package com.hyunny.data.di

import com.hyunny.data.repository.NewsRepositoryImpl
import com.hyunny.data.repository.TopicRepositoryImpl
import com.hyunny.data.repository.UserDataRepositoryImpl
import com.hyunny.domain.repository.NewsRepository
import com.hyunny.domain.repository.TopicRepository
import com.hyunny.domain.repository.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsUserDataRepository(
        userDataRepository: UserDataRepositoryImpl
    ): UserDataRepository

    @Binds
    @Singleton
    fun bindsTopicRepository(
        topicRepository: TopicRepositoryImpl
    ): TopicRepository

    @Binds
    @Singleton
    fun bindsNewsRepository(
        newsRepository: NewsRepositoryImpl
    ): NewsRepository

}
