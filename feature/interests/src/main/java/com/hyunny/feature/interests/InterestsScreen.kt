package com.hyunny.feature.interests

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hyunny.model.Topic
import com.hyunny.model.Topic.Business
import com.hyunny.model.Topic.Entertainment
import com.hyunny.model.Topic.General
import com.hyunny.model.Topic.Health
import com.hyunny.model.Topic.Science
import com.hyunny.model.Topic.Sports
import com.hyunny.model.Topic.Technology

@Composable
fun InterestsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CountrySelector()
        Divider()
        CategorySelector(
            onCategoryClick = {  }
        )
    }
}

@Composable
private fun CountrySelector() {
    // TODO
}

@Composable
private fun CategorySelector(
    onCategoryClick: (Topic) -> Unit
) {
    Topic.values().forEach {
        CategoryItem(onClick = { onCategoryClick(it) }, topic = it)
    }
}

@Composable
private fun CategoryItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    topic: Topic
) {
    Row(
        modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = topic.icon),
            contentDescription = topic.displayText
        )
        Text(text = topic.displayText)
        // TODO. Add Checkbox
    }
}

private val Topic.icon: Int
    @DrawableRes get() = when (this) {
        General -> R.drawable.ic_newspaper
        Business -> R.drawable.ic_business
        Entertainment -> R.drawable.ic_entertainment
        Health -> R.drawable.ic_health
        Science -> R.drawable.ic_science
        Sports -> R.drawable.ic_sports
        Technology -> R.drawable.ic_technology
    }
