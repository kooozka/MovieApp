package edu.pwr.kozanecki.movieapplication.composables.movieDetailsScreen

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.common.util.Util
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ConcatenatingMediaSource2
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
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
        var showCast by remember { mutableStateOf(false) }
        var showVideos by remember { mutableStateOf(false) }
        Column {
            MovieDetails(movie = Data.moviesList[index])
            Buttons(
                onScenesClick = { showScenes = true; showCast = false; showVideos = false},
                onActorsClick = { showCast = true; showScenes = false; showVideos = false },
                onVideosClick = { showVideos = true; showScenes = false; showCast = false},
                showScenes, showCast, showVideos)
            if (showScenes) DisplayScenes(movieScenes = Data.moviesList[index].scenes)
            else if (showCast) DisplayActors(
                actors = Data.moviesList[index].actors
            )
            else VideoPlayer(videos = Data.moviesList[index].videos)
        }
    }
    }
}