package com.hyunny.feature.interests

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InterestsScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CountrySelector()
        Divider()
        CategorySelector()
    }
}

@Composable
private fun CountrySelector() {

}

@Composable
private fun CategorySelector() {

}

@Composable
private fun CategoryItem() {

}
