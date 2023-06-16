package com.hyunny.feature.mynews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyunny.domain.usecase.GetFollowableTopicUseCase
import com.hyunny.domain.usecase.GetHeadlinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MyNewsViewModel @Inject constructor(
    getFollowableTopic: GetFollowableTopicUseCase,
    getHeadlines: GetHeadlinesUseCase
) : ViewModel() {

    val onboardingUiState: StateFlow<OnboardingUiState> =
        getFollowableTopic().map { followableTopics ->
            if (followableTopics.any { it.isFollowed }) {
                OnboardingUiState.NotShown
            } else OnboardingUiState.Shown
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = OnboardingUiState.Loading
        )

    val curPageStateFlow: MutableStateFlow<Int> = MutableStateFlow(1)

    val feedUiState: StateFlow<FeedUiState> =
        curPageStateFlow.flatMapLatest {
            getHeadlines(it).map { headlines ->
                headlines.articles.let(FeedUiState::Success)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = FeedUiState.Loading
        )

    fun fetchNext() {
        curPageStateFlow.value++
    }

}
