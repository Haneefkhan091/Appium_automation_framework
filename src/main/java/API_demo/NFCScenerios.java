package API_demo;

import org.testng.annotations.Test;

import Page_factory.nfc;
import Utlis.BaseTest;

public class NFCScenerios extends BaseTest {
	@Test
	public void foregrounddispatch() {
		// TODO Auto-generated method stub

		nfc nfc = new nfc(driver);
		nfc.gototextfield_foreground();
	}
}
