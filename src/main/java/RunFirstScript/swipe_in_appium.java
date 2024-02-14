package RunFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class swipe_in_appium extends BaseTest  {

	@Test
	public void swipe() {
		// TODO Auto-generated method stub
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
//		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("focusable"),"true");

		 scrollingmethods scrollingMethods = new scrollingmethods(driver);
		 scrollingMethods.swipeRight(firstImage);
		 

	}
}
