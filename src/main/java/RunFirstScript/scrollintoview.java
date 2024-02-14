package RunFirstScript;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

@Test
public class scrollintoview extends BaseTest {

	public void scroll() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		// where to scroll is known prior
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

	}

}
