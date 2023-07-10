package com.hyunny.feature.mynews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hyunny.core.design.theme.TheNewsTheme
import com.hyunny.model.Article
import com.hyunny.model.Source

@Composable
fun ArticlePoster(
    article: Article,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 4.dp,
        tonalElevation = 2.dp
    ) {
        Column {
            AsyncImage(
                model = article.urlToImage,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Article"
            )

            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Row {
                    Text(
                        modifier = Modifier.fillMaxWidth(0.75f),
                        text = article.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
private fun ArticlePreview() {
    TheNewsTheme {
        ArticlePoster(
            article = Article(
                source = Source(id = null, name = ""),
                author = null,
                title = "",
                description = "",
                url = "",
                urlToImage = null,
                publishedAt = "",
                content = ""
            )
        )
    }
}
