package android.ilius.net.tracker;

import static org.junit.Assert.assertEquals;

import com.lib.tracker.Tracker;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
  @Test
  public void addition_isCorrect() throws Exception {
    assertEquals("Internal Java", new Tracker().getFlavor());
  }
}
