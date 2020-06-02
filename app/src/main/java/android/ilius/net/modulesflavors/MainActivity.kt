package android.ilius.net.modulesflavors

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lib.tracker.Constants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_text).append(Constants.FLAVOR_CONFIGURED_IN_JAVA)
        findViewById<TextView>(R.id.tv_text).append("\n")
        findViewById<TextView>(R.id.tv_text).append(BuildConfig.SERVER_URL)
    }
}
