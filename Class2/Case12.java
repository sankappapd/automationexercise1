package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario12;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case12 {
	private WebDriver driver;
	private Pomscenario12 pomscenario12;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario12 = new Pomscenario12(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario12.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2,dependsOnMethods = "testHomePageVisibility")
	public void productselect() {
		pomscenario12.productsclick();
	}

	@Test(priority = 3, dependsOnMethods = "productselect")
	public void productaddtocart() {
		pomscenario12.addtocartitem();
		pomscenario12.continuetoadd();
		pomscenario12.continuetoaddcart2();
		pomscenario12.viewcartclick();
	}

	@Test(priority = 4, dependsOnMethods = "productaddtocart")
	public void testnameVisibility() {
		boolean productsverify = pomscenario12.productsverify();
		Assert.assertTrue(productsverify, "NAME IS NOT VISIBLE");
	}

	@Test(priority = 4, dependsOnMethods = "testnameVisibility")
	public void testproduct1rateVisibility() {
		boolean products1rateverify = pomscenario12.products1rateverify();
		Assert.assertTrue(products1rateverify, "PRODUCT IS NOT VISIBLE");

	}

	@Test(priority = 5, dependsOnMethods = "testproduct1rateVisibility")
	public void testproducs1quantityVisibility() {
		boolean products1quantityverify = pomscenario12.products1quantityverify();
		Assert.assertTrue(products1quantityverify, "QUANTITY NOT CORRECT");

	}

	@Test(priority = 6, dependsOnMethods = "testproduct1quantityVisibility")
	public void testproduct1totalpriceVisibility() {
		boolean products1totalpriceverify = pomscenario12.products1totalpriceverify();
		Assert.assertTrue(products1totalpriceverify, "TOTTAL PRICE IS NOT CORRECT");

	}

	@Test(priority = 7, dependsOnMethods = "testproduct1totalpriceVisibility")
	public void testname2Visibility() {
		boolean products2verify = pomscenario12.products2verify();
		Assert.assertTrue(products2verify, "NAME OF ITEM IS NOT CORRECT");
	}

	@Test(priority = 4, dependsOnMethods = "testname2Visibility")
	public void testproduct2rateVisibility() {
		boolean products2rateverify = pomscenario12.products2rateverify();
		Assert.assertTrue(products2rateverify, "ITEM RATE IS NOT CORRECT");

	}

	@Test(priority = 4, dependsOnMethods = "testproduct2rateVisibility")
	public void testproduct2quantityVisibility() {
		boolean products2quantityverify = pomscenario12.products2quantityverify();
		Assert.assertTrue(products2quantityverify, "PRODUCT QUANTITY IS NOT CORRECT");

	}

	@Test(priority = 4, dependsOnMethods = "testproduct2quantityVisibility")
	public void testproduct2totalpriceVisibility() {
		boolean products1tota2priceverify = pomscenario12.products1tota2priceverify();
		Assert.assertTrue(products1tota2priceverify, "TOTAL PRICE IS NOT CORRECT");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
