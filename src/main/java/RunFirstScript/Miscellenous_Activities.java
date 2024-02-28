package RunFirstScript;

import org.testng.annotations.Test;

import Utlis.BaseTest;
import io.appium.java_client.AppiumBy;

public class Miscellenous_Activities extends BaseTest{

	@Test
	public void Miscellenous_Activities() {
		// TODO Auto-generated constructor stub
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		
	
	}
}
