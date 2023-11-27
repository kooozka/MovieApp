package edu.pwr.kozanecki.movieapplication.composables.movieDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import edu.pwr.kozanecki.movieapplication.composables.MyTopBar
import edu.pwr.kozanecki.movieapplication.data.Data

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(index: Int) {
    Scaffold(
        topBar = { MyTopBar() }
    ) {innerPadding -> Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        color = MaterialTheme.colorScheme.background
    ) {
        var showScenes by remember { mutableStateOf(true) }
        Column {
            MovieDetails(movie = Data.moviesList[index])
            Buttons(
                onScenesClick = { showScenes = true },
                onActorsClick = { showScenes = false },
                showScenes)
            if (showScenes) DisplayScenes(movieScenes = Data.moviesList[index].scenes) else DisplayActors(
                actors = Data.moviesList[index].actors
            )
        }
    }
    }
}