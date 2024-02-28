package API_demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
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

//        String fullText = linkifyinsidetext.getText();
//        
//        // Separate text with ".com" and store in the 'links' variable
//        String[] sentences = fullText.split("\\.com");
//
//        // Print only the portions that end with ".com"
//        for (String sentence : sentences) {
//            if (sentence.trim().endsWith(".com")) {
//                System.out.println(sentence.trim() + ".com");
//            }
//        }
//        
        
        driver.navigate().back();
        
        view.Marquee.click();
        view.getmarquebutton();
        
        driver.navigate().back();
        
        
	}

}
