package jp.s64.example.ep2basedlib

import android.content.Context
import android.view.View
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * `com.google.android.exoplayer2.ui.StyledPlayerView` are built with Layout XML.
 * - https://github.com/google/ExoPlayer/blob/dd430f70/library/ui/src/main/java/com/google/android/exoplayer2/ui/StyledPlayerView.java
 * - https://github.com/google/ExoPlayer/blob/dd430f70/library/ui/src/main/res/layout/exo_styled_player_view.xml
 */
class MyPlayerFactoryImpl : MyPlayerFactory<StyledPlayerView> {

    override fun createView(context: Context): StyledPlayerView {
        return StyledPlayerView(context)
    }

}
