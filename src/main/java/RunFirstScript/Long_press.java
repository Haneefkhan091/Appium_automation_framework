package RunFirstScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Utlis.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;

public class Long_press extends BaseTest {
	@Test
	public void longpress() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();

		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
//		String textpersonname = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
//		textpersonname.getText();

		WebElement ele = driver.findElement(AppiumBy.xpath(".//*[@text='People Names']"));
		

		//##### This code work ####
		longPress(driver, ele);
		String sampletext = driver.findElement(By.id("android:id/title")).getText();
		boolean sampletext2 = driver.findElement(By.id("android:id/title")).isDisplayed();
		
		assertTrue(sampletext2);
		assertEquals(sampletext, "Sample menu");

		
		







		// long press
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
//						"duration",2000));
	}
}
