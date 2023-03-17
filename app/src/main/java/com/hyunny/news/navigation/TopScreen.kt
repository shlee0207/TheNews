package com.hyunny.news.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hyunny.news.R

enum class TopScreen(
    val route: String,
    @StringRes val titleResId: Int,
    @DrawableRes val IconId: Int
) {
     MyNews(
        route = "my_news_route",
        titleResId = R.string.title_my_news,
        IconId = R.drawable.ic_my_news
    ),
    Bookmarks(
        route = "bookmarks_route",
        titleResId = R.string.title_bookmarks,
        IconId = R.drawable.ic_bookmark
    ),
    Interests(
        route = "interests_route",
        titleResId = R.string.title_interests,
        IconId = R.drawable.ic_interests
    )
}
