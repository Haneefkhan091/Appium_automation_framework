package Page_factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Action_package.action;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class nfc extends action {
	AndroidDriver driver;

	public nfc(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "NFC")
	public static WebElement nfcElement;

	// Accessibility ID: "accessForegroundDispatch"
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ForegroundDispatch']")
	public static WebElement accessForegroundDispatchElement;

	// ID: "io.appium.android.apis:id/text"
	@AndroidFindBy(id = "io.appium.android.apis:id/text")
	public static WebElement textFieldElement;
	
	
	public static void gototextfield_foreground() {
		// TODO Auto-generated method stub
		nfcElement.click();
		accessForegroundDispatchElement.click();
		textFieldElement.click();
		System.out.println(textFieldElement.getText());
		

	}

}
