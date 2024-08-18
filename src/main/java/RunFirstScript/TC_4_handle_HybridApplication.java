package RunFirstScript;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utlis.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC_4_handle_HybridApplication extends BaseTest {

	@Test
	public void tc1() throws InterruptedException {
		// TODO Auto-generated method stub

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Haneef khan");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Afghanistan\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Afghanistan']")).click();

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 1 Mid SE\"));"));
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productPrices.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price; // 160.97 + 120 =280.97
			System.out.println("The total price is :" + totalSum);

		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		System.out.println("Price after adding to cart" + displayFormattedSum);
		Assert.assertEquals(Double.valueOf(totalSum), displayFormattedSum);

		Thread.sleep(4000);
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPress(driver, ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		Thread.sleep(6000);
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}

		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Haneef Ullah linkdln profiles");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
}
