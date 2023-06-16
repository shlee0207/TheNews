package com.hyunny.data.repository

import com.hyunny.data.network.NewsApi
import com.hyunny.domain.repository.NewsRepository
import com.hyunny.model.Article
import com.hyunny.model.Headlines
import com.hyunny.model.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {

    override fun getHeadlines(page: Int): Flow<Headlines> = flow {
        val response = newsApi.fetchHeadlines(page = page)
        emit(
            Headlines(
                totalResults = response.totalResults,
                articles = response.articles.map {
                    Article(
                        source = Source(
                            it.source.id,
                            it.source.name
                        ),
                        author = it.author,
                        title = it.title,
                        description = it.description,
                        url = it.url,
                        urlToImage = it.urlToImage,
                        publishedAt = it.publishedAt,
                        content = it.content,
                    )
                }
            )
        )
    }.flowOn(Dispatchers.IO)

}
