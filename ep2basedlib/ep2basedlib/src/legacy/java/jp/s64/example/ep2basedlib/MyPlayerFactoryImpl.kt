package jp.s64.example.ep2basedlib

import android.content.Context
import com.google.android.exoplayer2.ui.PlayerView
import java.net.URI

/**
 * `com.google.android.exoplayer2.ui.PlayerView` are built with Layout XML.
 * - https://github.com/google/ExoPlayer/blob/dd430f70/library/ui/src/main/java/com/google/android/exoplayer2/ui/PlayerView.java#L356
 * - https://github.com/google/ExoPlayer/blob/dd430f70/library/ui/src/main/res/layout/exo_player_view.xml
 */
class MyPlayerFactoryImpl : MyPlayerFactory<PlayerView> {

    override fun createView(context: Context): PlayerView {
        return PlayerView(context)
    }

}
