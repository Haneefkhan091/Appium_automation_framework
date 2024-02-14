package RunFirstScript;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Page_factory.FormPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

public class Ec_commerce_TC__2_toast_and_beforeclassExplanation extends BaseTest {

	@BeforeMethod
	public void beforeeachmethod() {

		// TODO Auto-generated method stub
		// Create an Intent to launch the activity
		String getheader = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		System.out.println(getheader);
		Assert.assertEquals(getheader, "General Store");
	}

	@Test(priority = 0)
	public void toast() {
		// TODO Auto-generated method stub

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		String toast = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toast, "Please enter your name");
	}

	@Test(priority = 1)
	public void seconedTest() {
		// TODO Auto-generated method stub
		FormPage formpage = new FormPage(driver);
		formpage.setNameField("Haneef khan");
		formpage.setGender();
		formpage.setCountrySelection("Afghanistan");

		formpage.clickletsshop();
	}

}
