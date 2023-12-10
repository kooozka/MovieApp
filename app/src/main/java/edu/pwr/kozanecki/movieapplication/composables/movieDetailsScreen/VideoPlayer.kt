package edu.pwr.kozanecki.movieapplication.composables.movieDetailsScreen

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayer(videos: List<Int>) {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()
    videos.map { videoId ->  MediaItem.fromUri("android.resource://${context.packageName}/$videoId")}
    exoPlayer.setMediaItems(videos.map { videoId ->  MediaItem.fromUri("android.resource://${context.packageName}/$videoId")})
    exoPlayer.prepare()

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    player = exoPlayer
                    useController = true
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
        )
    }

    DisposableEffect(key1 = exoPlayer) {
        onDispose {
            exoPlayer.release()
        }
    }
}