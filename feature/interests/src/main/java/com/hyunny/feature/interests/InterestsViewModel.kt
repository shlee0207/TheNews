package com.hyunny.feature.interests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyunny.domain.model.FollowableTopic
import com.hyunny.domain.usecase.GetFollowableTopicUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class InterestsViewModel @Inject constructor(
    getFollowableTopics: GetFollowableTopicUseCase
) : ViewModel() {

    val uiState: StateFlow<InterestsUiState> =
        getFollowableTopics().map(
            InterestsUiState::Interests
        ).stateIn(
            scope = viewModelScope,
            started = WhileSubscribed(stopTimeoutMillis = 5000L),
            initialValue = InterestsUiState.Loading
        )

}

sealed interface InterestsUiState {
    object Loading : InterestsUiState

    data class Interests(
        val topics: List<FollowableTopic>
    ) : InterestsUiState
}
