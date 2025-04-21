package jp.s64.example.ep2basedlib

import android.content.Context
import android.view.View
import androidx.annotation.UiThread
import com.google.android.exoplayer2.ui.AdViewProvider
import java.net.URI

interface MyPlayerFactory<T> where T: View, T: AdViewProvider {

    @UiThread
    fun createView(context: Context): T

    /*
    @UiThread
    fun play(player: T, uri: URI)
    */

}
