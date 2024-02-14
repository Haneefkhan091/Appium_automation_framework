package RunFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Browserbase extends BrowserBaseTest {
	
	
	@Test
	public void browser() {
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Haneef Ullah linkdln profiles");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
