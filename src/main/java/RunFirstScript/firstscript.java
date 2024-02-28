package RunFirstScript;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utlis.BaseTest;

import org.*;
//import org.testng.asserts.*;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class firstscript extends BaseTest {

	@Test
	public void script() throws InterruptedException {
		// Now the driver should be initialized before using it

	
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//Device rotation
		testLandscapeRightRotation();
		
		String alerttitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(alerttitle, "WiFi settings");
		
		
//		Thread.sleep(10000);
		// Cope and paste in appium
		driver.setClipboardText("HANEEF WIFI");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		// if class names with same name have two element how to access that the below
		// method is for that
//        driver.findElement(AppiumBy.className("android.widget.Button")).get(1).click();

		driver.findElement(By.id("android:id/button1")).click();

	}
}
