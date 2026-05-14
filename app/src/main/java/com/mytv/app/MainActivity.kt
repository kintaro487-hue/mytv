package com.mytv.app

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : FragmentActivity() {
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val playerView = StyledPlayerView(this)
        setContentView(playerView)

        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        // Bạn thay link phim của bạn vào đây nhé
        val videoUrl = "https://example.com/test-movie.mp4"
        val mediaItem = MediaItem.fromUri(videoUrl)
        
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}
