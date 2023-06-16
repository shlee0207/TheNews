package com.hyunny.feature.mynews

sealed interface OnboardingUiState {

    object Loading : OnboardingUiState

    object NotShown : OnboardingUiState

    object Shown : OnboardingUiState
}
