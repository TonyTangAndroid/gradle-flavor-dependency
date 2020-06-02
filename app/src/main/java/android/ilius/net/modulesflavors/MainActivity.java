package android.ilius.net.modulesflavors;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.lib.tracker.Constants;

public final class MainActivity extends AppCompatActivity {

  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_main);
    TextView textView = this.findViewById(R.id.tv_text);
    textView.append(Constants.FLAVOR_CONFIGURED_IN_JAVA);
    textView.append("\n");
    textView.append(BuildConfig.SERVER_URL);
    textView.append("\n");
    textView.append(metadata("metadata_1"));
    textView.append("\n");
    textView.append(metadata("metadata_2"));
    textView.append("\n");
    textView.append(BuildConfig.APPLICATION_ID);
    textView.append("\n");
    textView.append(authority());
  }

  private final CharSequence metadata(String metadataKey) {
    try {
      ApplicationInfo ai =
          getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
      Bundle bundle = ai.metaData;
      return bundle.getString(metadataKey);
    } catch (NameNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private final CharSequence authority() {
    try {
      Context context = getApplicationContext();
      ComponentName component = new ComponentName(context, FileProvider.class);
      return context
          .getPackageManager()
          .getProviderInfo(component, PackageManager.GET_META_DATA)
          .authority;
    } catch (NameNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
