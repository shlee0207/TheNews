package com.hyunny.feature.mynews

import com.hyunny.model.Article

sealed interface FeedUiState {

    object Loading : FeedUiState

    data class Success(
        val articles: List<Article> = emptyList()
    ) : FeedUiState
}
