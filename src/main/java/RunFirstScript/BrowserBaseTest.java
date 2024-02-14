package RunFirstScript;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BrowserBaseTest {
	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static WebDriver driver2;

	@BeforeClass
	public void configureappium() throws MalformedURLException {
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("emulator-5554");
//		options.setApp("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\APK\\ApiDemos-debug (2).apk");
//
//		// Assign the initialized driver to the class-level variable
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Haneef-ullah\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("emulator-5554");// device emulater
		options.setChromedriverExecutable("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\ChromeDriver\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");

//		options.setApp("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\APK\\ApiDemos-debug (2).apk");
//		options.setApp("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\APK\\001 General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

}
