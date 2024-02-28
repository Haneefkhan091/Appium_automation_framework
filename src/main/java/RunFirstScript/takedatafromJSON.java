package RunFirstScript;

import java.util.HashMap;
import Utlis.*;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;

import Action_package.action;
import Page_factory.CartPage;
import Page_factory.FormPage;
import Page_factory.ProductCatalogue;

public class takedatafromJSON extends BaseTest {

    @Test(dataProvider = "getDataFromJson")
    public void tc1(HashMap<String, String> testData) throws InterruptedException {
        // TODO Auto-generated method stub

        String name = testData.get("name");
        String gender = testData.get("gender");
        String country = testData.get("country");

        FormPage formpage = new FormPage(driver);
        formpage.setNameField(name);
        formpage.setGender();
        formpage.setCountrySelection(country);

        formpage.clickletsshop();
        ProductCatalogue addtocart = new ProductCatalogue(driver);
        action scrollaction = new action(driver);
        addtocart.addItemToCartByIndex(0);
        scrollaction.scrollToText("Jordan Lift Off");
        addtocart.addItemToCartByIndex(0);
        addtocart.goToCartPage();
        CartPage cart = new CartPage(driver);
        double totalsum = cart.getProductsSum();
        double displyformatedsum = cart.getTotalAmountDisplayed();
        Assert.assertEquals(totalsum, displyformatedsum);
        cart.acceptTermsConditions();
        cart.submitOrder();
    }

    // DataProvider method supplying test data from JSON
    @DataProvider
    public Object[][] getDataFromJson() throws Exception {
        // Provide the path to your JSON file
        String jsonFilePath = "C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\src\\main\\java\\testdata\\data.json";
		return BaseTest.getDataFromJson(jsonFilePath);
		
}
}