package Utlis;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseTest {
	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static WebDriver driver2;

	@BeforeClass(alwaysRun = true)
	public void configureappium() throws IOException {
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("emulator-5554");
//		options.setApp("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\APK\\ApiDemos-debug (2).apk");
//
//		// Assign the initialized driver to the class-level variable
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		
		Properties prop =  new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\src\\main\\java\\testdata\\data.properties");
		prop.load(file);
		String Url = prop.getProperty("Url");
		String port = prop.getProperty("Port");
		String DeviceName = prop.getProperty("DeviceName");
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Haneef-ullah\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(Url).usingPort(Integer.parseInt(port)).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(DeviceName);// device emulater
		options.setChromedriverExecutable("‪C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\ChromeDriver\\chromedriver.exe");

		options.setApp("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\APK\\ApiDemos-debug.apk");
//		options.setApp("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\APK\\001 General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPress(AndroidDriver driver, WebElement element) {
		Point location = element.getLocation();
		Dimension size = element.getSize();

		Point centerOfElement = getCenterOfElement(location, size);

		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofSeconds(2)))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singletonList(sequence));
	}

	public Point getCenterOfElement(Point location, Dimension size) {
		return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
	}

	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),

						"direction", direction, "percent", 0.75));

	}
	
//	public static void startActivity(AndroidDriver driver, String packageName, String activityName) {
//	    Activity activity = new Activity(packageName, activityName);
//	    ((AndroidDriver) driver).startsActivity(activity);
//	}


	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//Report"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1. capture and place in folder //2. extent report pick file and attach to report
		
		  
		
	}
	public static void testLandscapeRightRotation() {
		DeviceRotation rotation = new DeviceRotation(0, 0, 90);
		driver.rotate(rotation);
		assertEquals(driver.rotation(), rotation);
	}
	 public static Object[][] getDataFromJson(String jsonFilePath) throws Exception {
	        List<HashMap<String, String>> testDataList = new Gson().fromJson(new FileReader(jsonFilePath),
	                new TypeToken<List<HashMap<String, String>>>() {}.getType());

	        // Convert List of Maps to Object[][]
	        Object[][] testData = new Object[testDataList.size()][1];
	        for (int i = 0; i < testDataList.size(); i++) {
	            testData[i][0] = testDataList.get(i);
	        }

	        return testData;
	    }
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}

	public void swipeLeftToRight() {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();

		int startX = (int) (width * 0.2);
		int endX = (int) (width * 0.8);
		int centerY = height / 2;

		PointOption startPoint = PointOption.point(startX, centerY);
		PointOption endPoint = PointOption.point(endX, centerY);

		new io.appium.java_client.TouchAction<>(driver).press(startPoint)
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(endPoint).release().perform();
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {

		driver.quit();
	}

}
