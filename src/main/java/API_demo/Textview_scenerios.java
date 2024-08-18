package API_demo;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Page_factory.API_demo_views;
import Utlis.BaseTest;
import io.appium.java_client.AppiumBy;

public class Textview_scenerios extends BaseTest {

	@Test
	public void textview() throws InterruptedException {
		// TODO Auto-generated method stub
		API_demo_views view = new API_demo_views(driver);
		view.gototextfield();
		view.inputtext("I am going for Hajj this year inshAllah");
		driver.navigate().back();
		Thread.sleep(1000);
		view.linkify.click();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); // Adjust the timeout as needed
		WebElement linkifyinsidetext = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("io.appium.android.apis:id/text1")));
		System.out.println(linkifyinsidetext.getText());

            
        driver.navigate().back();
        
        view.Marquee.click();
        view.getmarquebutton();
        
        driver.navigate().back();
        
        
	}

}
