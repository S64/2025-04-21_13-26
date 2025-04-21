package jp.s64.example.media3app

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import jp.s64.example.ep2basedlib.MyPlayerFactory
import jp.s64.example.ep2basedlib.MyPlayerFactoryImpl

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val container: FrameLayout by lazy { findViewById(R.id.container) }

    private val factory: MyPlayerFactory<*> by lazy { MyPlayerFactoryImpl() }

    private lateinit var player: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()

        player = factory.createView(this)
        container.addView(player)
    }

    private fun initActivity() {
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
