package edu.pwr.kozanecki.movieapplication.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import edu.pwr.kozanecki.movieapplication.data.SampleData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(index: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movie List") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) {innerPadding -> Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        color = MaterialTheme.colorScheme.background
    ) {
        var showScenes by remember { mutableStateOf(true) }
        Column {
            MovieDetails(movie = SampleData.moviesList[index])
            Buttons(
                onScenesClick = { showScenes = true },
                onActorsClick = { showScenes = false })
            if (showScenes) DisplayScenes(movieScenes = SampleData.moviesList[index].scenes) else DisplayActors(
                actors = SampleData.moviesList[index].actors
            )
        }
    }
    }
}