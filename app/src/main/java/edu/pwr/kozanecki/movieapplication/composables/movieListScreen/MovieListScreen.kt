package edu.pwr.kozanecki.movieapplication.composables.movieListScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import edu.pwr.kozanecki.movieapplication.composables.MyTopBar
import edu.pwr.kozanecki.movieapplication.data.Data

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesListScreen(navController: NavController) {
    Scaffold(
        topBar = { MyTopBar() }
    ) {innerPadding -> Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        color = MaterialTheme.colorScheme.background
    ) {
        MovieList(movies = Data.moviesList, navController = navController)
    }
    }
}