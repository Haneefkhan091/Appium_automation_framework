package RunFirstScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

public class Properties{
	
	@Test
	public void prop() throws FileNotFoundException {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\src\\main\\java\\testdata\\data.properties");

//		String Url = prop.getProperty("Url");
//		String port = prop.getProperty("Port");
//		String DeviceName = prop.getProperty("DeviceName");
	}

}
