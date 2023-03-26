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
import com.hyunny.model.Category
import com.hyunny.model.Category.Business
import com.hyunny.model.Category.Entertainment
import com.hyunny.model.Category.General
import com.hyunny.model.Category.Health
import com.hyunny.model.Category.Science
import com.hyunny.model.Category.Sports
import com.hyunny.model.Category.Technology

@Composable
fun InterestsScreen(
    viewModel: InterestsViewModel,
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
    onCategoryClick: (Category) -> Unit
) {
    Category.values().forEach {
        CategoryItem(onClick = { onCategoryClick(it) }, category = it)
    }
}

@Composable
private fun CategoryItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    category: Category
) {
    Row(
        modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = category.icon),
            contentDescription = category.displayText
        )
        Text(text = category.displayText)
        // TODO. Add Checkbox
    }
}

private val Category.icon: Int
    @DrawableRes get() = when (this) {
        General -> R.drawable.ic_newspaper
        Business -> R.drawable.ic_business
        Entertainment -> R.drawable.ic_entertainment
        Health -> R.drawable.ic_health
        Science -> R.drawable.ic_science
        Sports -> R.drawable.ic_sports
        Technology -> R.drawable.ic_technology
    }
