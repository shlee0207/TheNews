package com.hyunny.news.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hyunny.news.R

sealed class TopScreen(
    val route: String,
    @StringRes val titleResId: Int,
    @DrawableRes val IconId: Int
) {
    object MyNews : TopScreen(
        route = "my_news_route",
        titleResId = R.string.title_my_news,
        IconId = R.drawable.ic_my_news
    )

    object Bookmarks : TopScreen(
        route = "bookmarks_route",
        titleResId = R.string.title_bookmarks,
        IconId = R.drawable.ic_bookmark
    )

    object Interests : TopScreen(
        route = "interests_route",
        titleResId = R.string.title_interests,
        IconId = R.drawable.ic_interests
    )
}
