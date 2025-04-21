package jp.s64.example.ep2basedlib

import android.content.Context
import com.google.android.exoplayer2.ui.PlayerView
import java.net.URI

class MyPlayerFactoryImpl : MyPlayerFactory<PlayerView> {

    override fun createView(context: Context): PlayerView {
        return PlayerView(context)
    }

}
