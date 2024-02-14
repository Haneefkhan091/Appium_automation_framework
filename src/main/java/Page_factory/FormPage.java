package Page_factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Action_package.action;

public class FormPage extends action {

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public WebElement nameField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	public WebElement maleOption;

	@AndroidFindBy(id = "android:id/text1")
	public WebElement countrySelection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pakistan']")
	public WebElement countryclick;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;

	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}

	public void setGender() {
		maleOption.click();
	}
	
	public void clickletsshop() {
		shopButton.click();
	}

	
	
	public void setCountrySelection(String countryName) {
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
	}

}
