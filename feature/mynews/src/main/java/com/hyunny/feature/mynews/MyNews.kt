package com.hyunny.feature.mynews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hyunny.feature.mynews.R.string
import com.hyunny.model.Article

@Composable
fun MyNewsScreen(
    onNavigateToInterestsClick: () -> Unit,
    viewModel: MyNewsViewModel = hiltViewModel()
) {
    val onboardingUiState by viewModel.onboardingUiState.collectAsStateWithLifecycle()
    val feedUiState by viewModel.feedUiState.collectAsStateWithLifecycle()

    when (onboardingUiState) {
        OnboardingUiState.Loading -> {}
        OnboardingUiState.Shown -> {
            OnBoarding(
                onFollowButtonClick = onNavigateToInterestsClick
            )
        }
        OnboardingUiState.NotShown -> {
            Headlines(feedUiState)
        }
    }
}

@Composable
private fun OnBoarding(
    modifier: Modifier = Modifier,
    onFollowButtonClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.guidance_title),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.size(18.dp))
        Text(
            modifier = Modifier.padding(horizontal = 50.dp),
            text = stringResource(id = R.string.guidance_description),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(32.dp))
        Button(
            onClick = { onFollowButtonClick() },
            modifier = Modifier.width(250.dp)
        ) {
            Text(stringResource(id = string.caption_move_to_follow))
        }
    }
}

@Composable
private fun Headlines(
    feedUiState: FeedUiState,
) {
    when (feedUiState) {
        FeedUiState.Loading -> {}
        is FeedUiState.Success -> {
           Headlines(articles = feedUiState.articles)
        }
     }
}

@Composable
private fun Headlines(
    articles: List<Article>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(articles) {
            ArticlePoster(article = it)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnBoardingPreview() {
    MaterialTheme {
        OnBoarding()
    }
}
