package RunFirstScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Action_package.action;
import Page_factory.CartPage;
import Page_factory.FormPage;
import Page_factory.ProductCatalogue;
import Utlis.BaseTest;
import io.appium.java_client.AppiumBy;

public class ec_commerce_tc_1 extends BaseTest {

	@Test
	public void tc1() throws InterruptedException {
		// TODO Auto-generated method stub

		FormPage formpage = new FormPage(driver);
		formpage.setNameField("Haneef khan");
		formpage.setGender();
		formpage.setCountrySelection("Afghanistan");

		formpage.clickletsshop();
		ProductCatalogue addtocart = new ProductCatalogue(driver);
		action scrollaction = new action(driver);
		addtocart.addItemToCartByIndex(0);
		scrollaction.scrollToText("Jordan Lift Off");
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
}
