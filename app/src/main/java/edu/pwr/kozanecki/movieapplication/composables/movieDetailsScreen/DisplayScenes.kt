package edu.pwr.kozanecki.movieapplication.composables.movieDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import edu.pwr.kozanecki.movieapplication.R

@Composable
fun DisplayScenes(movieScenes: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(movieScenes.size) { index ->
            Image(
                painter = painterResource(id = movieScenes[index]),
                contentDescription = stringResource(R.string.scene_photo_description, index),
                modifier = Modifier
                    .size(130.dp)
                    .fillMaxSize()
            )
        }

    }
}