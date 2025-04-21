package jp.s64.example.media3app

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LaunchTest {

    @Test
    fun testLaunch() {
        launchActivity<MainActivity>().use {
            InstrumentationRegistry.getInstrumentation().waitForIdleSync()
        }
    }

}
