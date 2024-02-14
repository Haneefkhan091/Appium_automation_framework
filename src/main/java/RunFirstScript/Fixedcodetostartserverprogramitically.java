package RunFirstScript;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.android.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Fixedcodetostartserverprogramitically {
    static AppiumServiceBuilder service = new AppiumServiceBuilder();

    @Test
    public static void script() throws MalformedURLException {
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File(
                        "C:\\Users\\Haneef-ullah\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\APK\\ApiDemos-debug (2).apk");

//        AndroidDriver driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // Your test logic goes here

        driver.quit();
        service.stop();
    }
}
