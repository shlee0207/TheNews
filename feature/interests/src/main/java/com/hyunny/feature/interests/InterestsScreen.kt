package com.hyunny.feature.interests

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hyunny.domain.model.FollowableTopic
import com.hyunny.feature.interests.R.drawable
import com.hyunny.model.Topic

@Composable
fun InterestsScreen(
    viewModel: InterestsViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when (val uiState = state) {
        InterestsUiState.Loading -> {
            // TODO
        }

        is InterestsUiState.Interests -> {
            InterestsScreenContent(
                uiState.topics,
                onFollowButtonClick = {
                    viewModel.toggleFollowableTopic(it)
                }
            )
        }
    }
}

@Composable
private fun InterestsScreenContent(
    topics: List<FollowableTopic>,
    onFollowButtonClick: (FollowableTopic) -> Unit,
    modifier: Modifier = Modifier
) = Column(
    modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
) {
    CountrySelector()
    Divider()
    Topics(
        topics = topics,
        onTopicClick = { /*TODO*/ },
        onFollowButtonClick = onFollowButtonClick
    )
}

@Composable
private fun CountrySelector() {
    // TODO
}

@Composable
private fun Topics(
    topics: List<FollowableTopic>,
    onTopicClick: (Topic) -> Unit,
    onFollowButtonClick: (FollowableTopic) -> Unit,
    modifier: Modifier = Modifier
) = Column(modifier) {
    topics.forEach {
        TopicItem(
            item = it,
            onItemClick = { onTopicClick(it.topic) },
            onFollowButtonClick = { onFollowButtonClick(it) }
        )
    }
}

@Composable
private fun TopicItem(
    item: FollowableTopic,
    onItemClick: () -> Unit,
    onFollowButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) = Row(
    modifier
        .clickable { onItemClick() }
        .padding(16.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Icon(
        painter = painterResource(id = item.topic.icon),
        contentDescription = item.topic.name,
        tint = Color.Unspecified
    )
    Text(
        text = item.topic.name,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .weight(1f)
            .padding(horizontal = 16.dp),
    )
    IconButton(
        onClick = { onFollowButtonClick() },
    ) {
        Icon(
            painter = painterResource(
                if (item.isFollowed) {
                    drawable.ic_check_circle_24
                } else {
                    drawable.ic_add_24
                }
            ),
            contentDescription = item.topic.name,
        )
    }
}

private val Topic.icon: Int
    @DrawableRes get() = when (name) {
        "General" -> R.drawable.ic_newspaper
        "Business" -> R.drawable.ic_business
        "Entertainment" -> R.drawable.ic_entertainment
        "Health" -> R.drawable.ic_health
        "Science" -> R.drawable.ic_science
        "Sports" -> R.drawable.ic_sports
        "Technology" -> R.drawable.ic_technology
        else -> -1
    }
