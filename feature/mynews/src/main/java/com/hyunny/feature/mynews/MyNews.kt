package com.hyunny.feature.mynews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyNewsScreen(
    onNavigateToInterestsClicked: () -> Unit
) {
    Guidance(
        onFollowButtonClick = onNavigateToInterestsClicked
    )
}

@Composable
fun Guidance(
    modifier: Modifier = Modifier,
    onFollowButtonClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize().padding(vertical = 48.dp),
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
            Text(stringResource(id = R.string.caption_move_to_follow))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuidancePreview() {
    Guidance()
}
