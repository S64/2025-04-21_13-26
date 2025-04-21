package jp.s64.example.ep2basedlib

import android.content.Context
import android.view.View
import com.google.android.exoplayer2.ui.StyledPlayerView

class MyPlayerFactoryImpl : MyPlayerFactory<StyledPlayerView> {

    override fun createView(context: Context): StyledPlayerView {
        return StyledPlayerView(context)
    }

}
