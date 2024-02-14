package RunFirstScript;

import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Actvity_class extends BaseTest {
	@Test
	public void activity()  throws MalformedURLException{
		// command :: adb shell dumpsys window | find "mCurrentFocus"
		
		Activity activity =  new Activity("io.appium.android.apis", "io.appium.android.apis.preference.FragmentPreferences");
//		driver.startActivity(activity);
	
		
	}
	
	

}
