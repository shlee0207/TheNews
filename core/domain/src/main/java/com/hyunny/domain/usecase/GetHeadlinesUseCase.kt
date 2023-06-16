package com.hyunny.domain.usecase

import com.hyunny.domain.repository.NewsRepository
import com.hyunny.domain.repository.UserDataRepository
import com.hyunny.model.Headlines
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetHeadlinesUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository,
    private val newsRepository: NewsRepository
) {

    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(page: Int): Flow<Headlines> {
        return userDataRepository.userData
            .map {
                it.followableTopicIds
            }
            .distinctUntilChanged()
            .flatMapLatest {
                if (it.isEmpty()) {
                    flowOf(EmptyHeadlines)
                } else {
                    newsRepository.getHeadlines(page)
                }
            }
    }

}

private val EmptyHeadlines =
    Headlines(
        totalResults = 0,
        articles = emptyList()
    )
