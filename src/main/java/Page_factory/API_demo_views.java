
package Page_factory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Action_package.action;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class API_demo_views extends action {
	AndroidDriver driver;

	public API_demo_views(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Assuming "Text" is the accessibilityId for the element
	@AndroidFindBy(accessibility = "Text")
	public WebElement textElement;

	// Assuming "LogTextBox" is the accessibilityId for the element
	@AndroidFindBy(accessibility = "LogTextBox")
	public WebElement longTextElement;

	// Assuming "Add" is the accessibilityId for the element
	@AndroidFindBy(accessibility = "Add")
	public WebElement addElement;

	// Assuming "io.appium.android.apis:id/text" is the id for the element
	@AndroidFindBy(id = "io.appium.android.apis:id/text")
	public WebElement textFieldElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Linkify']")
	public WebElement linkify;
	@AndroidFindBy(id = "android:id/content")
	public WebElement linkifycontent;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Marquee']")
	public WebElement Marquee;
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='This use the default marquee animation limit of 3']")
	public WebElement marquebuttons;

	public void getmarquebutton() {
		// TODO Auto-generated method stub

		marquebuttons.click();
		System.out.println(marquebuttons.getText());
		
		assertEquals(marquebuttons.getText(), "THIS USE THE DEFAULT MARQUEE ANIMATION LIMIT OF 3");
	}

	public void gototextfield() {
		// Click on the "Text" element
		textElement.click();

		// Click on the "LogTextBox" element
		longTextElement.click();

		// Click on the "Add" element
		addElement.click();

	}

	public void gotolinkfyandtext() {
		// Click on the "Text" element

		linkify.click();

	}

	public void inputtext(String inputText) {

		textFieldElement.sendKeys(inputText);
	}

	// You can add more methods as per your test requirements
}
