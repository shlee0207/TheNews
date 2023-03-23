package com.hyunny.news.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hyunny.feature.bookmarks.Bookmarks
import com.hyunny.feature.interests.Interests
import com.hyunny.feature.mynews.MyNewsScreen
import com.hyunny.news.navigation.TopScreen
import com.hyunny.news.navigation.TopScreen.Bookmarks
import com.hyunny.news.navigation.TopScreen.Interests
import com.hyunny.news.navigation.TopScreen.MyNews

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TheNewApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {  padding ->

        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
        ) {
            CenterAlignedTopAppBar(
                title = { Text(navController.title()) }
            )

            NavHost(navController = navController, startDestination = MyNews.route) {
                composable(MyNews.route) {
                    MyNewsScreen(
                        onNavigateToInterestsClicked = {
                            navController.navigate(Interests.route) {
                                popUpTo(MyNews.route) { inclusive = true}
                            }
                        }
                    )
                }
                composable(Bookmarks.route) { Bookmarks() }
                composable(Interests.route) { Interests() }
            }
        }
    }
}

@Composable
private fun NavHostController.title(): String {
    val titleId = when (currentBackStackEntryAsState().value?.destination?.route) {
        MyNews.route -> MyNews.titleResId
        Bookmarks.route -> Bookmarks.titleResId
        Interests.route -> Interests.titleResId
        else -> null
    }
    return titleId?.let { stringResource(id = it) } ?: ""
}

@Composable
fun BottomBar(
    navController: NavHostController
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        TopScreen.values().asList().forEach { screen ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = screen.IconId), contentDescription = null) },
                label = { Text(stringResource(id = screen.titleResId)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
