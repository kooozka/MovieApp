package edu.pwr.kozanecki.movieapplication.composables.movieDetailsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import edu.pwr.kozanecki.movieapplication.R

@Composable
fun Buttons(
    onScenesClick: () -> Unit,
    onActorsClick: () -> Unit,
    onVideosClick: () -> Unit,
    isShowScenes: Boolean,
    isShowCast: Boolean,
    isShowVideos: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
    ) {
        if (isShowScenes) {
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.my_app_yellow))
                    .weight(1f)
                    .clickable { onScenesClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = stringResource(R.string.scenes),
                    style = MaterialTheme.typography.titleMedium)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onActorsClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = stringResource(R.string.actors),
                    style = MaterialTheme.typography.titleMedium)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onVideosClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = stringResource(R.string.videos),
                    style = MaterialTheme.typography.titleMedium)
            }
        } else if (isShowCast) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onScenesClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = stringResource(R.string.scenes),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.my_app_yellow))
                    .weight(1f)
                    .clickable { onActorsClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = stringResource(R.string.actors),
                    style = MaterialTheme.typography.titleMedium)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onVideosClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = stringResource(R.string.videos),
                    style = MaterialTheme.typography.titleMedium)
            }
        } else {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onScenesClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = stringResource(R.string.scenes),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onActorsClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = stringResource(R.string.actors),
                    style = MaterialTheme.typography.titleMedium)
            }
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.my_app_yellow))
                    .weight(1f)
                    .clickable { onVideosClick() }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = stringResource(R.string.videos),
                    style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}