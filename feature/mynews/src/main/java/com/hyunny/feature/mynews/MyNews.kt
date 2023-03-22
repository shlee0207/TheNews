package com.hyunny.feature.mynews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyNews() {
    Guidance()
}

@Composable
fun Guidance(
    modifier: Modifier = Modifier,
    onFollowButtonClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(id = R.string.guidance_title))
        Text(stringResource(id = R.string.guidance_description))
        Button(
            onClick = { onFollowButtonClick() },
            modifier = Modifier.width(250.dp)
        ) {
            Text(stringResource(id = R.string.caption_move_to_follow))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuidancePreview() {
    Guidance()
}
