package RunthroughTesNGXML;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Action_package.action;
import Page_factory.CartPage;
import Page_factory.FormPage;
import Page_factory.ProductCatalogue;
import RunFirstScript.BaseTest;
import io.appium.java_client.AppiumBy;

public class ec_commerce_tc_1 extends BaseTest {
	
	@Test(dataProvider = "getData",groups = {"Smoke"})
	public void tc1(String name, String shoes, String country) throws InterruptedException {
		// TODO Auto-generated method stub

		FormPage formpage = new FormPage(driver);
		formpage.setNameField(name);
		formpage.setGender();
		formpage.setCountrySelection(country);

		formpage.clickletsshop();
		ProductCatalogue addtocart = new ProductCatalogue(driver);
		action scrollaction = new action(driver);
		addtocart.addItemToCartByIndex(0);
		scrollaction.scrollToText(shoes);
		addtocart.addItemToCartByIndex(0);
		addtocart.goToCartPage();
		CartPage cart = new CartPage(driver);
		double totalsum = cart.getProductsSum();
		double displyformatedsum = cart.getTotalAmountDisplayed();
		Assert.assertEquals(totalsum, displyformatedsum);
		cart.acceptTermsConditions();
		cart.submitOrder();

		
		
//		Thread.sleep(3000);
//		int productcount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
//
//		for (int i = 0; i < productcount; i++) {
//			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
//					.getText();
//
//			if (productName.equalsIgnoreCase("Jordan Lift Off")) {
//				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//				System.out.println("Clicked on add to cart Product is Jordan lift Off");
//			}
//		}

//		Thread.sleep(4000);
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(
//				driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
//
//		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//		Assert.assertEquals(lastPageProduct, "Jordan Lift Off");

	}
	
	
	 @DataProvider
	    public Object[][] getData() {
	        // You can modify and add more test data here
	        return new Object[][] {
	                { "Haneef khan", "Jordan Lift Off", "Afghanistan" },
//	                { "John Doe", "Female", "USA" },
	                // Add more rows with different test data as needed
	        };
	    }
}
