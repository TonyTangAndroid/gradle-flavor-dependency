package android.ilius.net.modulesflavors

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lib.tracker.Constants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.tv_text)
        textView.append(Constants.FLAVOR_CONFIGURED_IN_JAVA)
        textView.append("\n")
        textView.append(BuildConfig.SERVER_URL)
        textView.append("\n")
        textView.append(metadata("metadata_1"))
        textView.append("\n")
        textView.append(metadata("metadata_2"))
    }

    private fun metadata(metadataKey: String): CharSequence? {
        val ai = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        val bundle = ai.metaData
        return bundle.getString(metadataKey)
    }
}
